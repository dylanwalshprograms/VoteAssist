package co.grandcircus.VoteAssist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.grandcircus.VoteAssist.repository.AdminRepository;

@Controller
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepo;
	
	@RequestMapping("/admin")
	public String adminDashboard() {
		return "admin";
	}

}
