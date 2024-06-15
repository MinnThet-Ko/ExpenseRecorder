package com.er.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.er.models.Account;
import com.er.repositories.JdbcAccountRepository;
import com.er.repositories.JpaAccountRepository;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private JdbcAccountRepository accountRepository;
	
	@Autowired
	private JpaAccountRepository jpaAccountRepository;

	// Methods for creating new account
	@GetMapping("/createNewAccount")
	public String displayAccountEntryForm(Model model) {
		System.out.println("In displayAccountEntryForm method:");
		model.addAttribute("account", new Account());
		model.addAttribute("actionType", "insert");
		return "accountEntryForm";
	}

	@PostMapping("/createNewAccount")
	public String processAccountEntryForm(@ModelAttribute Account account, Model model) {
		System.out.println("In processAccountEntryForm method:");
		System.out.println(account.toString());
		//this.accountRepository.saveAccount(account);
		this.jpaAccountRepository.save(account);
		return "redirect:/";
	}

	@GetMapping("/update")
	public String displayAccountUpdateForm(@RequestParam(value = "accountID") String accountID, Model model) {
		//Account resultAccount = this.accountRepository.getAccountByID(accountID);
		Optional<Account> resultAccount = this.jpaAccountRepository.findById(accountID);
		if (resultAccount != null) {
			model.addAttribute("account", resultAccount.get());
			model.addAttribute("actionType", "update");
			return "accountEntryForm";
		}
		return "redirect:/";
	}

	@PostMapping("/update")
	public String processAccountUpdateForm(@ModelAttribute Account account, Model model) {
		System.out.println("In processAccountUpdateForm method:");
		System.out.println(account.toString());
		this.accountRepository.updateAccount(account);
		return "redirect:/";
	}

	@GetMapping("/delete")
	public String processAccountDelete(@ModelAttribute Account account, Model model) {
		System.out.println("In processAccountDelete method:");
		System.out.println(account.toString());
		this.jpaAccountRepository.delete(account);
		return "redirect:/";
	}
}
