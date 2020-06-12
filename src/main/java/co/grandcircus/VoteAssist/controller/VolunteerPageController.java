package co.grandcircus.VoteAssist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.grandcircus.VoteAssist.Service.GoogleCivicsApiService;
import co.grandcircus.VoteAssist.entity.VoterData;
import co.grandcircus.VoteAssist.model.CivicApiResponse;
import co.grandcircus.VoteAssist.repository.VoterRepository;

@Controller
public class VolunteerPageController {
	
	@Autowired
	private GoogleCivicsApiService googleService;
	
	@Autowired
	private VoterRepository voterRepo;
	
	
	@RequestMapping("/")
	public String home(Model model) {
		
		VoterData voterData = voterRepo.findVoterByNextCall();
		
		
		CivicApiResponse civicResponse = googleService.civicResponse(voterData.getAddress(), 
				voterData.getCity(), voterData.getState(), voterData.getZip());;
		
		
		
		model.addAttribute("civicResponse", civicResponse);
		model.addAttribute("voter", voterData);
		
		return "home";
		
	}

}
