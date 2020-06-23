package co.grandcircus.VoteAssist.controller;

import java.io.Serializable;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping("/") // Initial view for all users
	public String login(Model model) {
		if (session.getAttribute("user") != null) {
			return "redirect:/home";
		} else {
			return "login";
		}
	}

	@RequestMapping("/login/submit") // Checks login credentials against DB for confirmation. Also checks admin login
	public String submitLoginForm(@RequestParam("userName") String userName, @RequestParam("password") String password,
			@RequestParam(required = true) String loginType, Model model) {

		Optional<Volunteer> foundUser = volunteerRepo.findByUserNameAndPassword(userName, password);
		if (foundUser.isPresent()) {
			if (loginType.equals("admin")) {
				if (foundUser.get().getIsAdmin()) {
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
			model.addAttribute("message", "Incorrect username or password.");
			return "login";
		}

	}

	@RequestMapping("/sign-up") // Sign-up view
	public String signUpForm() {
		return "sign-up";
	}

	@RequestMapping("/sign-up/submit") // Volunteer credential creation
	public String signUpSubmit(Volunteer volunteer, @RequestParam("password") String password,
			@RequestParam("passwordConfirm") String passwordConfirm, @RequestParam String email, Model model) {

		Volunteer volunteerCheck = volunteerRepo.findByUserName(volunteer.getUserName());
		// Checks against multiple of the same username
		if (volunteerCheck != null) {
			model.addAttribute("message", "Username already exists. Please try again.");
			return "sign-up";
			// Checks to confirm passwords match as well as meet a minimum length
		} else if (password.length() < 8) {
			if (!password.equals(passwordConfirm)) {
				model.addAttribute("message", "Passwords do not match. Please try again.");
				return "sign-up";
			}
			model.addAttribute("message",
					"Password is too short. Please try again with a length of 8-20 characters (letters, numbers, and special characters only).");
			return "sign-up";
		} else {
			volunteerRepo.save(volunteer);
			return "redirect:/training";
		}
	}

	@RequestMapping("/forgot-password")
	public String forgotPassword() {

		return "forgot-password";
	}

	@RequestMapping("forgot-password/submit")
	public String forgotPasswordSubmit(@RequestParam String email, Model model) {
<<<<<<< Updated upstream
		Volunteer volunteer = volunteerRepo.findByEmail(email);
		if (volunteer == null) {
			String message = "No volunteer accounts are associated with " + email;
			model.addAttribute("message", message);
			return "redirect:/forgot-password";

		} else {
			Random rand = new Random();
			int randomNumber = rand.nextInt(1000000);
			session.setAttribute("email", email);
			session.setAttribute("randomNumber", randomNumber);
			emailService.emailParams(email, "Password Reset Code", "Your reset code is: " + randomNumber,
					"voteassist.admn@gmail.com");
		}
		return "recover-password";
	}

	@RequestMapping("/recover-password")
	public String recoverPassword(@RequestParam int code, Model model) {
		System.out.println(code);
		int randomNumber = (int) session.getAttribute("randomNumber");
		if (code == randomNumber) {
			return "reset-password";
		} else {
			model.addAttribute("message", "Your code does not match, please try again.");
			return "redirect:/recover-password";
		}
	}

	@RequestMapping("/reset-password/submit")
	public String resetPassword(@RequestParam String password, @RequestParam String passwordConfirm, Model model) {
		if (password.length() < 8) {
			if (!password.equals(passwordConfirm)) {
				model.addAttribute("message", "Passwords do not match. Please try again.");
				return "redirect:/reset-password/submit";
			}
			model.addAttribute("message",
					"Password is too short. Please try again with a length of 8-20 characters (letters, numbers, and special characters only).");
			return "redirect:/reset-password/submit";
		} else {
			Volunteer volunteer = volunteerRepo.findByEmail((String) session.getAttribute("email"));
			volunteer.setPassword(password);
			volunteerRepo.save(volunteer);
			return "redirect:/";
		}
=======
		
		String message = "";
		
		model.addAttribute("message", message);
		return "redirect:/forgot-password";
>>>>>>> Stashed changes
	}
}
