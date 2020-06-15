package co.grandcircus.VoteAssist.controller;



import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.VoteAssist.Service.GoogleCivicsApiService;
import co.grandcircus.VoteAssist.Service.VoteSmartApiService;
import co.grandcircus.VoteAssist.entity.CallLog;
import co.grandcircus.VoteAssist.entity.VoterData;
import co.grandcircus.VoteAssist.model.CivicApiResponse;
import co.grandcircus.VoteAssist.model.StateVoteInfoResponse;
import co.grandcircus.VoteAssist.repository.CallLogRepository;
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
	
	private long delayNA = 24;
	private long delayVIP = 48;
	private long delayWVBM = 72;
	private long delayAVBM = 96;
	
	
	
	@RequestMapping("/home")
	public String home(Model model) {
		
		VoterData voterData = voterRepo.findVoterByNextCall();
				
		CivicApiResponse civicResponse = googleService.civicResponse(voterData.getAddress(), 
				voterData.getCity(), voterData.getState(), voterData.getZip());
		
		StateVoteInfoResponse stateResponse = voteSmartService.stateVoterInfoResponse(voterData.getState());
		
				model.addAttribute("stateResponse", stateResponse);
				model.addAttribute("civicResponse", civicResponse);
				model.addAttribute("voter", voterData);
		
		if (voterData.getNextCall() == null) {
			return "home";
		}
		else if (voterData.getNextCall().compareTo(LocalDateTime.now()) >= 0) { 
			return "no-more-records";
		}
			
		return "home";
		
	}
	
	@RequestMapping("/submit")
	public String submitNext(@RequestParam String notes,
			@RequestParam(required = true) String result, @RequestParam(required = false) String nextCall,
			@RequestParam String button, @RequestParam Long voterId, Model model) {
		LocalDateTime currentTime = LocalDateTime.now();
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
		
		CallLog log = new CallLog(currentTime, volunteerRepo.findById(1L).orElse(null), voterRepo.findById(voterId).orElse(null));
		callLogRepo.save(log);
		//TODO create confirmation page or popup window for demo purposes
		
		if (button.equals("next")) {
			return "redirect:/home";
		} else {
			return "no-more-records";
		}
		
	}

}
