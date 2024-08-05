package com.er.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.er.models.Account;
import com.er.models.User;
import com.er.repositories.AccountRepository;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

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
		User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		account.setUser(loggedInUser);
		this.accountRepository.save(account);
		return "redirect:/";
	}

	@GetMapping("/update")
	public String displayAccountUpdateForm(@RequestParam(value = "accountID") String accountID, Model model) {
		//Account resultAccount = this.accountRepository.getAccountByID(accountID);
		Optional<Account> resultAccount = this.accountRepository.findById(accountID);
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
		this.accountRepository.save(account);
		return "redirect:/";
	}

	@GetMapping("/delete")
	public String processAccountDelete(@ModelAttribute Account account, Model model) {
		System.out.println("In processAccountDelete method:");
		System.out.println(account.toString());
		this.accountRepository.delete(account);
		return "redirect:/";
	}
}
