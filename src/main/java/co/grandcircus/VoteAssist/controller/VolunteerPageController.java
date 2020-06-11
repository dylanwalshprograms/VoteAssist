package co.grandcircus.VoteAssist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.grandcircus.VoteAssist.Service.GoogleCivicsApiService;
import co.grandcircus.VoteAssist.model.CivicApiResponse;

@Controller
public class VolunteerPageController {
	
	@Autowired
	private GoogleCivicsApiService googleService;
	
	
	@RequestMapping("/")
	public String home(Model model) {
		
		String address = "3011 Rowena Los Angeles CA 90039";
		
		CivicApiResponse civicResponse = googleService.civicResponse(address);
		
		model.addAttribute("civicResponse", civicResponse);
		
		return "home";
		
	}

}
