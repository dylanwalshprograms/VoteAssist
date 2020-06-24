package co.grandcircus.VoteAssist.controller;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.VoteAssist.Service.ElectionService;
import co.grandcircus.VoteAssist.Service.EmailService;
import co.grandcircus.VoteAssist.Service.GoogleCivicsApiService;
import co.grandcircus.VoteAssist.Service.TimeMachineService;
import co.grandcircus.VoteAssist.Service.VoteSmartApiService;
import co.grandcircus.VoteAssist.entity.CallLog;
import co.grandcircus.VoteAssist.entity.Volunteer;
import co.grandcircus.VoteAssist.entity.VoterData;
import co.grandcircus.VoteAssist.methods.VoteAssistMethods;
import co.grandcircus.VoteAssist.model.CivicApiResponse;
import co.grandcircus.VoteAssist.model.StateVoteInfoResponse;
import co.grandcircus.VoteAssist.model.VoterElectionInformation;
import co.grandcircus.VoteAssist.repository.AdminRepository;
import co.grandcircus.VoteAssist.repository.CallLogRepository;
import co.grandcircus.VoteAssist.repository.RegDayRepo;
import co.grandcircus.VoteAssist.repository.VoterRepository;

@Controller
public class VolunteerPageController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private GoogleCivicsApiService googleService;
	
	@Autowired
	private VoteSmartApiService voteSmartService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private VoterRepository voterRepo;
	
	@Autowired
	private CallLogRepository callLogRepo;
	
	@Autowired
	private RegDayRepo regDayRepo;

	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private ElectionService electionService;
	
	@Autowired
	private TimeMachineService timeMachineService;
	
	@Autowired
	private HttpSession session;
		
	@RequestMapping("/training") // Training view
	public String training() {
		return "training";
	}
	
	@RequestMapping("/logout") // Logout logic, checks session to confirm user is logged in
	public String logout(RedirectAttributes redir, Model model) {
		if (session.getAttribute("user") != null) {
			redir.addFlashAttribute("message","Logged out successfully");
			
			session.invalidate();
			return "redirect:/";
		} else {
			model.addAttribute("message", "Not logged in");
			return "login";
		}
	}
		
	@RequestMapping("/reset-time") // Mapping to force time change in program (For testing and demoing purposes).
	public String resetTime(@RequestParam(required = true) String time) {
		if (time == null || time.isEmpty()) {
			timeMachineService.disableTimeMachine();
		} else {
			LocalDateTime timeMachineTime = LocalDateTime.parse(time);
			timeMachineService.enableTimeMachine(timeMachineTime);
		}
		
		return "redirect:/home";
	}
		
	@RequestMapping("/home") // Primary view of program
	public String home(Model model) {
		
		String campaignName = adminRepo.findByLowestId().getCampaignName();
		String priority = adminRepo.findByLowestId().getPriority();
		
		LocalDateTime electionDay = electionService.getNextElectionDate();
		
		// Check to verify if user is in a session, goes to login if no
		if (session.getAttribute("user") == null) {
			return "login";
		}
		
		Volunteer currentVolunteer = (Volunteer) session.getAttribute("user");
		// Logic to pull next record, default filter method is by next call chronologically.
		VoterData voterData = new VoterData();

		if (priority == null) {
			priority = "prioritizeSTD";
		}
		if (priority.equals("prioritizeWVIP")) {
			voterData = voterRepo.findbyVIP();
		} else if (priority.equals("prioritizeWVBM")) {
			voterData = voterRepo.findbyWVBM();
		} else {
			voterData = voterRepo.findVoterByNextCall();
		}
		
		if (voterData == null) {
			return "no-more-records";
		}
 
		// Keeps multiple volunteers from pulling the same record
		voterData.setInUse(true);
		voterRepo.save(voterData);
		// List of calls made by voter ID (displays call log for volunteer)
		List<CallLog> callLog = callLogRepo.findByVoterDataId(voterData.getId());
		
		model.addAttribute("callLog", callLog);
		// Pulls from Google Civic API the list of offices and representatives, based on parameters of voter		
		CivicApiResponse civicResponse = googleService.civicResponse(voterData.getAddress(), 
				voterData.getCity(), voterData.getState(), voterData.getZip());
		// Calls Vote Smart API for state instructions to register/vote
		StateVoteInfoResponse stateResponse = voteSmartService.stateVoterInfoResponse(voterData.getState());
		// regCutOff is the logic that calculates deadline to register to vote in the voters state, based on current campaign
		LocalDateTime regCutoff = electionDay.minusDays(regDayRepo.findByStateId(voterData.getState()).getDaysBeforeElection());

		// Logic to filter DB in order to pull next record, based on lastCall and nextCall timestamps
		String lastCall = VoteAssistMethods.localDateTimeInWords(voterData.getLastCall());
		String nextCall = VoteAssistMethods.localDateTimeInWords(voterData.getNextCall());

		model.addAttribute("timeMachineString", timeMachineService.getTimeInWords());
		model.addAttribute("nextCall", nextCall);
		model.addAttribute("lastCall", lastCall);
		
		String scriptName = "main-script";
		VoterElectionInformation voterElectionInformaiton = new VoterElectionInformation(electionDay, regCutoff, currentVolunteer, campaignName, stateResponse, civicResponse, voterData);
		
		model.addAttribute("voterinformation", voterElectionInformaiton);
		
		// Logic to determine what script is used for voter, based on current disposition of voter
		if (voterData.getResult() == null) {
			scriptName = "main-script";
		} else if (voterData.getResult().equals("VIP")) {
			scriptName = "vip-reminder-script";
		} else if (voterData.getResult().equals("WVBM")) {
			scriptName = "vbm-reminder-script";
		}
		
		model.addAttribute("script", scriptName);
		// Logic to navigate to no more records view when no records are available
		if (voterData.getNextCall() == null) {
			return "home";
		}
		else if (voterData.getNextCall().compareTo(timeMachineService.getTime()) >= 0) {  //REPLACED BY TIME MACHINE LocalDateTime.now()) >= 0) { 
			return "no-more-records";
		}
			
		return "home";
		
	}
	
	@RequestMapping("/submit") // Submit/Next button in home view, saves notes and disposition of voter to DB
	public String submitNext(@RequestParam String notes,
			@RequestParam(required = true) String result, @RequestParam(required = false) String nextCall,
			@RequestParam String button, @RequestParam Long voterId, Model model) {

		LocalDateTime electionDay = electionService.getNextElectionDate();

		// Applies delays set by admin
		Long delayNA = adminRepo.findByLowestId().getDelayNA();
		Long delayVIP = adminRepo.findByLowestId().getDelayVIP();
		Long delayWVBM = adminRepo.findByLowestId().getDelayWVBM();
		Long delayAVBM = adminRepo.findByLowestId().getDelayAVBM();
		Long delayNV = adminRepo.findByLowestId().getDelayNV();
				
		LocalDateTime currentTime = timeMachineService.getTime();
		// Logic to pull next record
		VoterData voter = voterRepo.findById(voterId).orElse(null);
		// Displays cutoff to register to vote		
		LocalDateTime regCutoff = electionDay.minusDays(regDayRepo.findByStateId(voter.getState()).getDaysBeforeElection());
		// Sets disposition based on call results (Ln 190-240)		
		if (result.equals("NA")) {
			
			voter.setLastCall(currentTime);
			voter.setNextCall(currentTime.plusHours(delayNA));
			voter.setNotes(notes);
			voter.setResult(result);
			
		} else if (result.equals("RQ")) {
			
			voter.setLastCall(currentTime);
			voter.setNextCall(LocalDateTime.parse(nextCall));
			voter.setNotes(notes);
			voter.setResult(result);
			
		} else if (result.equals("VIP")) {
			
			voter.setLastCall(currentTime);
			voter.setNextCall(electionDay.minusDays(delayVIP));
			voter.setNotes(notes);
			voter.setResult(result);
			
		} else if (result.equals("WVBM")) {
			
			voter.setLastCall(currentTime);
			voter.setNextCall(regCutoff.minusDays(delayWVBM));
			voter.setNotes(notes);
			voter.setResult(result);
			
		} else if (result.equals("AVBM")) {
			
			voter.setLastCall(currentTime);
			voter.setNextCall(currentTime.plusHours(delayAVBM));
			voter.setNotes(notes);
			voter.setResult(result);
			
		} else if (result.equals("NV")) {
			
			voter.setLastCall(currentTime);
			voter.setNextCall(currentTime.plusHours(delayNV));
			voter.setNotes(notes);
			voter.setResult(result);
			
		} else if (result.equals("DNC")) {
			
			voter.setLastCall(currentTime);
			voter.setNextCall(currentTime.plusHours(0));
			voter.setNotes(notes);
			voter.setResult(result);
			voter.setDoNotCall(true);
			
		}
		// Sets record out of use and able to be pulled by another volunteer, then saves info on voter
		voter.setInUse(false);
		voterRepo.save(voter);
		// Creates new entry in call log DB with current fields, then saves
		CallLog log = new CallLog(currentTime, voter.getNextCall(), (Volunteer) session.getAttribute("user"), voterRepo.findById(voterId).orElse(null), voter.getResult(), voter.getNotes());
		callLogRepo.save(log);
		// Logic to either go next record or logout
		if (button.equals("next")) {
			return "redirect:/home";
		} else {
			return "redirect:/logout";
		}
		
	}
	
	@RequestMapping("/contact-admin") // Displays email popup window for admin contact
	public String contactAdmin() {
		return "contact-admin";
	}
	
	@RequestMapping("/send-admin-email") // Sends email
	public String emailAdmin(@RequestParam String returnAddress, @RequestParam String message) {
		emailService.sendMessageToAdmin(returnAddress, message);
		return "email-sent";
	}
	
	@RequestMapping("/email-popup") // Displays email popup window for voter communication
	public String emailPopup() {
		return "email-popup";
	}
	
	@RequestMapping("/send-email") // Sends email
	public String email(@RequestParam(required = true) String toEmail, 
			@RequestParam String subject, 
			@RequestParam String contentString) {
		
		emailService.sendMessageToVoter(toEmail, subject, contentString);
		
		return "email-sent";
	}

}
