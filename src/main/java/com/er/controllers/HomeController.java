package com.er.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.er.models.Account;
import com.er.repositories.JdbcAccountRepository;
import com.er.repositories.JpaAccountRepository;

@Controller
public class HomeController {

	@Autowired
	private JdbcAccountRepository jdbcAccountRepository;
	
	@Autowired
	private JpaAccountRepository accountRepository;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		List<Account> accountList = (List<Account>) this.accountRepository.findAll();
		model.addAttribute("accountList", accountList);
		return "home";
	}
}
