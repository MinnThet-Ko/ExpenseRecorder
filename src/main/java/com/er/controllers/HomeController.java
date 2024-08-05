package com.er.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.er.models.User;
import com.er.services.AccountService;
import com.er.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("accountList", this.accountService.getAccountsByUser(loggedInUser));
		return "home";
	}
}
