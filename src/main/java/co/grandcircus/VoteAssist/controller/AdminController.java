package co.grandcircus.VoteAssist.controller;

import java.io.Serializable;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.VoteAssist.entity.AdminConfiguration;
import co.grandcircus.VoteAssist.entity.Volunteer;
import co.grandcircus.VoteAssist.repository.AdminRepository;

@Controller
public class AdminController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/admin")
	public String adminDashboard() {
		String loginType = (String)session.getAttribute("loginType");
		Volunteer foundUser = (Volunteer)session.getAttribute("user");
		
		if (foundUser != null && loginType.equals("admin")) {
			return "admin";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping("/admin/update-config")
	public String adminUpdateConfig(AdminConfiguration adminConfig) {
		adminConfig = adminRepo.findAll();
		
		
		return "redirect:/admin";

	}
}	
	
	
	
