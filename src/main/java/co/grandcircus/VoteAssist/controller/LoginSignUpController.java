package co.grandcircus.VoteAssist.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.VoteAssist.entity.Volunteer;
import co.grandcircus.VoteAssist.repository.VolunteerRepository;

@Controller
public class LoginSignUpController {

	@Autowired
	private HttpSession session;
	
	@Autowired 
	private VolunteerRepository volunteerRepo;
	
	@RequestMapping ("/") // Home page
	public String login(Model model) {
		if (session.getAttribute("user") != null) {
			return "home";
		} else {
			return "login";
		}
	}
	
	@RequestMapping("/login/submit") // Login page
	public String submitLoginForm(@RequestParam("name") String name, @RequestParam("userName") String userName, @RequestParam("password") String password,
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
}
