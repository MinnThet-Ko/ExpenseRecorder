package com.er.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.er.models.User;
import com.er.repositories.UserRepository;
import com.er.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("user", new User());
		return "loginForm";
	}

	@PostMapping("/login")
	public String processLogin(@ModelAttribute User user, Model model) {
		return "redirect:/";
	}

	@GetMapping("/register")
	public String showRegisterationForm(Model model) {
		model.addAttribute("user", new User());
		return "registrationForm";
	}

	@PostMapping("/register")
	public String processRegisterationForm(@ModelAttribute User user, Model model) {
		this.userService.saveUser(user);
		return "redirect:/user/login";
	}

}
