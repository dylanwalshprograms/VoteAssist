package co.grandcircus.VoteAssist.controller;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.VoteAssist.Service.GoogleCivicsApiService;
import co.grandcircus.VoteAssist.Service.VoteSmartApiService;
import co.grandcircus.VoteAssist.entity.CallLog;
import co.grandcircus.VoteAssist.entity.Volunteer;
import co.grandcircus.VoteAssist.entity.VoterData;
import co.grandcircus.VoteAssist.methods.VoteAssistMethods;
import co.grandcircus.VoteAssist.model.CivicApiResponse;
import co.grandcircus.VoteAssist.model.StateVoteInfoResponse;
import co.grandcircus.VoteAssist.repository.AdminRepository;
import co.grandcircus.VoteAssist.repository.CallLogRepository;
import co.grandcircus.VoteAssist.repository.RegDayRepo;
import co.grandcircus.VoteAssist.repository.VolunteerRepository;
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
	private VoterRepository voterRepo;
	
	@Autowired
	private CallLogRepository callLogRepo;
	
	@Autowired 
	private VolunteerRepository volunteerRepo;
	
	@Autowired
	private RegDayRepo regDayRepo;

	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private HttpSession session;
		
	private LocalDateTime electionDay = LocalDateTime.of(2020, 11, 03, 8, 00, 00);
	
	private LocalDateTime timeMachineLDT = LocalDateTime.now();
	private String timeMachineString = VoteAssistMethods.localDateTimeInWords(timeMachineLDT);
	
	@RequestMapping("/training") // Mapping for training page view
	public String training() {
		return "training";
	}
	
	@RequestMapping("/logout") // Logs out current user
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
		
	@RequestMapping("/reset-time")
	public String resetTime(@RequestParam(required = true) String time) {
		
		if (time == null || time.isEmpty()) {
			timeMachineLDT = LocalDateTime.now();
			timeMachineString = VoteAssistMethods.localDateTimeInWords(timeMachineLDT);
		}
		else {
			timeMachineLDT = LocalDateTime.parse(time);
			timeMachineString = VoteAssistMethods.localDateTimeInWords(timeMachineLDT);
		}
		return "redirect:/home";
	}
		
	@RequestMapping("/home")
	public String home(Model model) {
		
		String campaignName = adminRepo.findByLowestId().getCampaignName();
		
		
		if (session.getAttribute("user") == null) {
			return "login";
		}
		
		Volunteer currentVolunteer = (Volunteer) session.getAttribute("user");
		
		VoterData voterData = voterRepo.findVoterByNextCall();
		voterData.setInUse(true);
		voterRepo.save(voterData);
				
		CivicApiResponse civicResponse = googleService.civicResponse(voterData.getAddress(), 
				voterData.getCity(), voterData.getState(), voterData.getZip());
		
		StateVoteInfoResponse stateResponse = voteSmartService.stateVoterInfoResponse(voterData.getState());
		
		LocalDateTime regCutoff = electionDay.minusDays(regDayRepo.findByStateId(voterData.getState()).getDaysBeforeElection());
		String lastCall = "";
		String nextCall = "";
		if (voterData.getLastCall() != null && voterData.getNextCall() != null) {
			lastCall = VoteAssistMethods.localDateTimeInWords(voterData.getLastCall());
			nextCall = VoteAssistMethods.localDateTimeInWords(voterData.getNextCall());
		}
		model.addAttribute("timeMachineString", timeMachineString);
		model.addAttribute("nextCall", nextCall);
		model.addAttribute("lastCall", lastCall);
		
		String scriptName = "main-script";
		
		model.addAttribute("electionDay", VoteAssistMethods.localDateTimeInWords(electionDay));
		model.addAttribute("regCutOffDay", VoteAssistMethods.localDateTimeInWords(regCutoff));
		model.addAttribute("volunteerName", currentVolunteer.getName());
		model.addAttribute("campaignName", campaignName);
		model.addAttribute("stateResponse", stateResponse);
		model.addAttribute("civicResponse", civicResponse);
		model.addAttribute("voter", voterData);
		
	
		if (voterData.getResult() == null) {
			scriptName = "main-script";
		} else if (voterData.getResult().equals("VIP")) {
			scriptName = "vip-reminder-script";
		} else if (voterData.getResult().equals("WVBM")) {
			scriptName = "vbm-reminder-script";
		}
		
		model.addAttribute("script", scriptName);
		
		if (voterData.getNextCall() == null) {
			return "home";
		}
		else if (voterData.getNextCall().compareTo(timeMachineLDT) >= 0) {  //REPLACED BY TIME MACHINE LocalDateTime.now()) >= 0) { 
			return "no-more-records";
		}
			
		return "home";
		
	}
	
	@RequestMapping("/submit")
	public String submitNext(@RequestParam String notes,
			@RequestParam(required = true) String result, @RequestParam(required = false) String nextCall,
			@RequestParam String button, @RequestParam Long voterId, Model model) {
		
		Long delayNA = adminRepo.findByLowestId().getDelayNA();
		Long delayVIP = adminRepo.findByLowestId().getDelayVIP();
		Long delayWVBM = adminRepo.findByLowestId().getDelayWVBM();
		Long delayAVBM = adminRepo.findByLowestId().getDelayAVBM();
		Long delayNV = adminRepo.findByLowestId().getDelayNV();
		
		
		LocalDateTime currentTime = timeMachineLDT;		// Replaced by TimeMachine LocalDateTime.now();
		
		VoterData voter = voterRepo.findById(voterId).orElse(null);
		voter.setInUse(false);
		
		LocalDateTime regCutoff = electionDay.minusDays(regDayRepo.findByStateId(voter.getState()).getDaysBeforeElection());
				
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
		
		voterRepo.save(voter);
		
		CallLog log = new CallLog(currentTime, voter.getNextCall(), (Volunteer) session.getAttribute("user"), voterRepo.findById(voterId).orElse(null), voter.getResult(), voter.getNotes());
		callLogRepo.save(log);
		
		if (button.equals("next")) {
			return "redirect:/home";
		} else {
			return "redirect:/logout";
		}
		
	}

}
