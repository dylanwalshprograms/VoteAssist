package co.grandcircus.VoteAssist.controller;



import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.VoteAssist.Service.GoogleCivicsApiService;
import co.grandcircus.VoteAssist.entity.CallLog;
import co.grandcircus.VoteAssist.entity.VoterData;
import co.grandcircus.VoteAssist.model.CivicApiResponse;
import co.grandcircus.VoteAssist.repository.CallLogRepository;
import co.grandcircus.VoteAssist.repository.VolunteerRepository;
import co.grandcircus.VoteAssist.repository.VoterRepository;

@Controller
public class VolunteerPageController {
	
	@Autowired
	private GoogleCivicsApiService googleService;
	
	@Autowired
	private VoterRepository voterRepo;
	
	@Autowired
	private CallLogRepository callLogRepo;
	
	@Autowired 
	private VolunteerRepository volunteerRepo;
	
	
	@RequestMapping("/home")
	public String home(Model model) {
		
		VoterData voterData = voterRepo.findVoterByNextCall();
		
		
		CivicApiResponse civicResponse = googleService.civicResponse(voterData.getAddress(), 
				voterData.getCity(), voterData.getState(), voterData.getZip());;
		
		
		
		model.addAttribute("civicResponse", civicResponse);
		model.addAttribute("voter", voterData);
		
		return "home";
		
	}
	
	@RequestMapping("/submit")
	public String submitNext(@RequestParam String notes,
			@RequestParam(required = true) String result, @RequestParam(required = false) String nextCall,
			@RequestParam String button, @RequestParam Long voterId, Model model) {
		LocalDateTime currentTime = LocalDateTime.now();
		//TODO get volunteer id from jsp once login function is built
		//TODO update voterdata
		CallLog log = new CallLog(currentTime, volunteerRepo.findById(1L).orElse(null), voterRepo.findById(voterId).orElse(null));
		callLogRepo.save(log);
		//TODO create confirmation page or popup window for demo purposes
		return "redirect:/home";
	}

}
