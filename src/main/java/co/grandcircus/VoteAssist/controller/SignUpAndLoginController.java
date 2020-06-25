package co.grandcircus.VoteAssist.controller;

import java.io.Serializable;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.VoteAssist.Service.EmailService;
import co.grandcircus.VoteAssist.entity.Volunteer;
import co.grandcircus.VoteAssist.repository.VolunteerRepository;

@Controller
public class SignUpAndLoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private VolunteerRepository volunteerRepo;

	@Autowired
	private HttpSession session;

	@Autowired
	private EmailService emailService;

	@RequestMapping("/") 
	public String login(Model model) {
		if (session.getAttribute("user") != null) {
			return "redirect:/home";
		} else {
			return "login";
		}
	}

	@RequestMapping("/login/submit") // Checks login credentials against DB for confirmation. Also checks admin login
	public String submitLoginForm(@RequestParam("userName") String userName, @RequestParam("password") String password,
			@RequestParam(required = true) String loginType, Model model, RedirectAttributes redir) {

		Optional<Volunteer> foundUser = volunteerRepo.findByUserNameAndPassword(userName, password);
		if (foundUser.isPresent()) {
			if (loginType.equals("admin")) {
				if (foundUser.get().getIsAdmin() != null && foundUser.get().getIsAdmin() == true) {
					session.setAttribute("user", foundUser.get());
					session.setAttribute("loginType", loginType);
					return "redirect:/admin";
				} else {
					model.addAttribute("message", "You do not have administrative access. Please login as volunteer.");
					return "login";
				}
			} else {
				session.setAttribute("user", foundUser.get());
				session.setAttribute("loginType", loginType);
				return "redirect:/home";
			}
		} else {
			//model.addAttribute("message", "Incorrect username or password.");
			redir.addFlashAttribute("message", "Incorrect username or password.");
			return "redirect:/";
		}

	}

	@RequestMapping("/sign-up") 
	public String signUpForm() {
		return "sign-up";
	}

	@PostMapping("/sign-up/submit") // Volunteer credential creation
	public String signUpSubmit(Volunteer volunteer, @RequestParam("password") String password,
			@RequestParam("passwordConfirm") String passwordConfirm, @RequestParam String email, RedirectAttributes redir, Model model) {

		Volunteer volunteerCheckUserName = volunteerRepo.findByUserName(volunteer.getUserName());
		Volunteer volunteerCheckEmail = volunteerRepo.findByEmail(volunteer.getEmail());
		// Checks against multiple of the same username
		if (volunteerCheckUserName != null || volunteerCheckEmail != null) {
			redir.addFlashAttribute("message", "Username or Email already exists. Please try again.");
			return "redirect:/sign-up";
			// Checks to confirm passwords match as well as meet a minimum length
		} else if (!password.equals(passwordConfirm)) {
				redir.addFlashAttribute("message", "Passwords do not match. Please try again.");
				return "redirect:/sign-up";
		} else {
			volunteerRepo.save(volunteer);
			return "redirect:/training";
		}
	}

	@RequestMapping("/forgot-password")
	public String forgotPassword() {

		return "forgot-password";
	}

	@RequestMapping("/forgot-password/submit")
	public String forgotPasswordSubmit(@RequestParam String email, Model model, RedirectAttributes redir) {
		Volunteer volunteer = volunteerRepo.findByEmail(email);
		if (volunteer == null) {
			String message = "No volunteer accounts are associated with " + email;
			redir.addFlashAttribute("message", message);
			return "redirect:/forgot-password";

		} else {
			Random rand = new Random();
			int randomNumber = rand.nextInt(1000000);
			session.setAttribute("email", email);
			session.setAttribute("randomNumber", randomNumber);
			emailService.messageToResetForgottonPasswords(email, randomNumber);
			return "email-code";
		}
	}

	@RequestMapping("/email-code")
	public String recoverPassword(@RequestParam(required = false) int code, Model model, RedirectAttributes redir) {
		System.out.println(code);
		int randomNumber = (int) session.getAttribute("randomNumber");
		if (code == randomNumber) {
			return "reset-password";
		} else {
			redir.addFlashAttribute("message", "Your code did not match, please try again.");
			return "redirect:/forgot-password";
		}
	}

	@PostMapping("/reset-password/submit")
	public String resetPassword(@RequestParam String password, @RequestParam String passwordConfirm, Model model, RedirectAttributes redir) {
		if (password.length() < 8) {
			if (!password.equals(passwordConfirm)) {
				redir.addFlashAttribute("message", "Passwords do not match. Please try again.");
				return "reset-password";
			}
			redir.addFlashAttribute("message",
					"Password is too short. Please try again with a length of 8-20 characters (letters, numbers, and special characters only).");
			return "reset-password";
		} else {
			Volunteer volunteer = volunteerRepo.findByEmail((String) session.getAttribute("email"));
			volunteer.setPassword(password);
			volunteerRepo.save(volunteer);
			return "password-update-success";
		}
	}
}
