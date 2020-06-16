package co.grandcircus.VoteAssist.controller;



import java.time.LocalDateTime;
import java.util.Optional;

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
import co.grandcircus.VoteAssist.repository.CallLogRepository;
import co.grandcircus.VoteAssist.repository.RegDayRepo;
import co.grandcircus.VoteAssist.repository.VolunteerRepository;
import co.grandcircus.VoteAssist.repository.VoterRepository;

@Controller
public class VolunteerPageController {
	
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
	private HttpSession session;
	
	private long delayNA = 24;
	private long delayVIP = 48;
	private long delayWVBM = 72;
	private long delayAVBM = 96;
	private String campaignName = "Test campaign 1";
	private LocalDateTime electionDay = LocalDateTime.of(2020, 11, 03, 8, 00, 00);
	
	private LocalDateTime timeMachineLDT = LocalDateTime.now();
	private String timeMachineString = VoteAssistMethods.localDateTimeInWords(timeMachineLDT);
	
	@RequestMapping ("/") // Home page
	public String login(Model model) {
		if (session.getAttribute("user") != null) {
			return "home";
		} else {
			return "login";
		}
	}
	
	@RequestMapping("/login/submit") // Login page
	public String submitLoginForm(@RequestParam("userName") String userName, @RequestParam("password") String password,
			Model model) {

		Optional<Volunteer> foundUser = volunteerRepo.findByUserNameAndPassword(userName, password);
		if (foundUser.isPresent()) {
			session.setAttribute("user", foundUser.get());
			return "redirect:/home";
		} else {
			model.addAttribute("message", "Incorrect username or password.");
			return "login";
		}
		
	}
	
	@RequestMapping("/sign-up")
	public String signUpForm() {
		return "sign-up";
	}
	
	@RequestMapping("/sign-up/submit")
	public String signUpSubmit(Volunteer volunteer, Model model) {
		
		Volunteer volunteerCheck = volunteerRepo.findByUserName(volunteer.getUserName());
		
		if (volunteerCheck != null) {
			model.addAttribute("message", "Username already exists. Please try again.");
			return "sign-up";
		} else {
			volunteerRepo.save(volunteer);
			return "redirect:/";
		}
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
	public String resetTime(@RequestParam(required = false) String time) {
		
		
		if (time != null) {
			timeMachineLDT = LocalDateTime.parse(time);
			timeMachineString = VoteAssistMethods.localDateTimeInWords(timeMachineLDT);
		}
		
		return "redirect:/home";
	}
		
	@RequestMapping("/home")
	public String home(Model model) { 		
		
		Volunteer currentVolunteer = (Volunteer) session.getAttribute("user");
		
		VoterData voterData = voterRepo.findVoterByNextCall();
				
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
		
		if (voterData.getNextCall() == null) {
			return "home";
		}
		else if (voterData.getNextCall().compareTo(timeMachineLDT) >= 0) {  //REPLACED BY TIME MACHINE LocalDateTime.now()) >= 0) { 
			return "no-more-records";
		}
		
		if (voterData.getResult().equals("WVBM")) {
			scriptName = "vbm-reminder-script";
		} else if (voterData.getResult().equals("VIP")) {
			scriptName = "vip-reminder-script";
		}
		
		model.addAttribute("script", scriptName);
			
		return "home";
		
	}
	
	@RequestMapping("/submit")
	public String submitNext(@RequestParam String notes,
			@RequestParam(required = true) String result, @RequestParam(required = false) String nextCall,
			@RequestParam String button, @RequestParam Long voterId, Model model) {
		
		LocalDateTime currentTime = timeMachineLDT;		// Replaced by TimeMachine LocalDateTime.now();
		
		//TODO get volunteer id from jsp once login function is built
		
		VoterData voter = voterRepo.findById(voterId).orElse(null);
		
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
			voter.setNextCall(currentTime.plusHours(delayVIP));
			voter.setNotes(notes);
			voter.setResult(result);
			
		} else if (result.equals("WVBM")) {
			
			voter.setLastCall(currentTime);
			voter.setNextCall(currentTime.plusHours(delayWVBM));
			voter.setNotes(notes);
			voter.setResult(result);
			
		} else if (result.equals("AVBM")) {
			
			voter.setLastCall(currentTime);
			voter.setNextCall(currentTime.plusHours(delayAVBM));
			voter.setNotes(notes);
			voter.setResult(result);
			
		} else if (result.equals("NV")) {
			
			voter.setLastCall(currentTime);
			voter.setNextCall(currentTime.plusHours(10000));
			voter.setNotes(notes);
			voter.setResult(result);
			
		} else if (result.equals("DNC")) {
			
			voter.setLastCall(currentTime);
			voter.setNextCall(currentTime.plusHours(10000));
			voter.setNotes(notes);
			voter.setResult(result);
			voter.setDoNotCall(true);
			
		}
		
		voterRepo.save(voter);
		
		CallLog log = new CallLog(currentTime, (Volunteer) session.getAttribute("user"), voterRepo.findById(voterId).orElse(null));
		callLogRepo.save(log);
		
		if (button.equals("next")) {
			return "redirect:/home";
		} else {
			return "no-more-records";
		}
		
	}

}
