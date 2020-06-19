package co.grandcircus.VoteAssist.controller;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.grandcircus.VoteAssist.entity.AdminConfiguration;
import co.grandcircus.VoteAssist.entity.Volunteer;
import co.grandcircus.VoteAssist.repository.AdminRepository;
import co.grandcircus.VoteAssist.repository.CallLogRepository;
import co.grandcircus.VoteAssist.repository.VolunteerRepository;
import co.grandcircus.VoteAssist.repository.VoterRepository;

@Controller
public class AdminController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private CallLogRepository callLogRepo;
	
	@Autowired
	private VolunteerRepository volunteerRepo;
	
	@Autowired 
	private VoterRepository voterRepo;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/admin")
	public String adminDashboard(Model model) {
		String loginType = (String)session.getAttribute("loginType");
		Volunteer foundUser = (Volunteer)session.getAttribute("user");
		int totalCalls = callLogRepo.findAllCallsMade();
		int totalVolunteers = volunteerRepo.findAllVolunteers();
		double totalWVBMAndWVIP = voterRepo.findAllWVBMAndWVIP();
		double totalNotVoting = voterRepo.findAllNotVoting();
		double totalDoNotCall = voterRepo.findAllDoNotCall();
		double totalResponsesMinusNAAndRQ = voterRepo.findAllResponsesMinusNAAndRQ();
		
		double totalVotersWhoWillVote = (totalWVBMAndWVIP/totalCalls) * 100;
		double percentOfNV = (totalNotVoting/totalResponsesMinusNAAndRQ) * 100;
		double percentOfDNC = (totalDoNotCall/totalResponsesMinusNAAndRQ) * 100;
		
		model.addAttribute("percentOfDNC", percentOfDNC);
		model.addAttribute("percentNV", percentOfNV);
		model.addAttribute("totalWillVote", totalVotersWhoWillVote);
		model.addAttribute("totalVolunteers", totalVolunteers);
		model.addAttribute("totalCalls", totalCalls);
		
		AdminConfiguration adminConfig = adminRepo.findByLowestId();
		model.addAttribute("adminConfig", adminConfig);
		if (foundUser != null && loginType.equals("admin")) {
			return "admin";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping("/admin/update-config")
	public String adminUpdateConfig(AdminConfiguration adminConfig) {
		
		adminRepo.deleteAll();
		adminRepo.save(adminConfig);
		
		
		return "redirect:/admin";

	}
}	
	
	
	
