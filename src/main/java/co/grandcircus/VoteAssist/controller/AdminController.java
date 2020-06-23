package co.grandcircus.VoteAssist.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.VoteAssist.Service.AdminService;
import co.grandcircus.VoteAssist.entity.AdminConfiguration;
import co.grandcircus.VoteAssist.entity.CallLog;
import co.grandcircus.VoteAssist.entity.Scripts;
import co.grandcircus.VoteAssist.entity.Volunteer;

import co.grandcircus.VoteAssist.repository.AdminRepository;
import co.grandcircus.VoteAssist.repository.CallLogRepository;
import co.grandcircus.VoteAssist.repository.ScriptRepository;
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
	private AdminService adminService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ScriptRepository scriptRepo;
	
	@RequestMapping("/admin") // Checks current session, finds user
	public String adminDashboard(Model model) {
		String loginType = (String)session.getAttribute("loginType");
		Volunteer foundUser = (Volunteer)session.getAttribute("user");
		// Calcs stats shown in admin view (Ln 51-60)
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
		// Limiter to only pull one campaign at a time (Ln 68+69)
		AdminConfiguration adminConfig = adminRepo.findByLowestId();
		model.addAttribute("adminConfig", adminConfig);
		// Logout
		if (foundUser != null && loginType.equals("admin")) {
			return "admin";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping("/admin/update-config") // Updates campaign information
	public String adminUpdateConfig(AdminConfiguration adminConfig) {
		
		adminRepo.deleteAll();
		adminRepo.save(adminConfig);
		
		
		return "redirect:/admin";

	}
	@RequestMapping("/call-log") // Displays entire list with no keyword, can be filtered in admin view, goes to call-log
	public String callLog(Model model, @RequestParam(value="keyword",required=false) String keyword) {
		if(keyword != null && !keyword.isEmpty()) {
			List<CallLog> callLog = callLogRepo.findByResultContainingIgnoreCase(keyword);
			
			model.addAttribute("callLog", callLog);
		}else {
			List<CallLog> callLog = callLogRepo.findAll();
			
			model.addAttribute("callLog", callLog);
		}
		
		
		return "call-log";
	
	}
	
	@RequestMapping("/reset-database") // Resets DB (for testing purposes)
	public String resetDatabaseForTesting() {
		voterRepo.resetDatabase();
		
		return "redirect:/admin";
	}
	
	@RequestMapping("/script-edit")
	public String test(@RequestParam String scriptName, Model model) {
		
		String script = adminService.adminScriptEditor(scriptName);
		Scripts scriptActual = scriptRepo.findByScriptName(script);
		
		model.addAttribute("script", scriptActual);
		
		return "admin-script-edit";
	}
	
	@RequestMapping("/script-submit") 
	public String submitEditedScript(@RequestParam String scriptName, @RequestParam String scriptText) {
		System.out.println(scriptName);
		System.out.println(scriptText);
		Scripts script = scriptRepo.findByScriptName(scriptName);
		script.setScriptText(scriptText);
		scriptRepo.save(script);
		System.out.println(script.getScriptText());
		return "redirect:/admin";
	}
}	
	
	
	
