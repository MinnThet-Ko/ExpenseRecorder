package com.er.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.er.models.Account;
import com.er.models.Voucher;
import com.er.repositories.JdbcAccountRepository;
import com.er.repositories.JdbcVoucherRepository;
import com.er.repositories.JpaAccountRepository;
import com.er.repositories.JpaVoucherRepository;

@Controller
@RequestMapping("/voucher")
public class VoucherController {
	
	@Autowired
	private JpaAccountRepository accountRepository;
	
	@Autowired
	private JpaVoucherRepository vocherRepository;
	
	@GetMapping("/insert")
	public String displayVoucherEntryForm(Model model) {
		model.addAttribute("voucher", new Voucher());
		model.addAttribute("accountList", this.accountRepository.findAll());
		model.addAttribute("actionType", "insert");
		return "voucherEntryForm";
	}
	
	@PostMapping("/insert")
	public String processVoucherEntry(@ModelAttribute Voucher voucher, Model model) {
		System.out.println("In processVoucherEntry method:");
		this.vocherRepository.save(voucher);
		Account currentAccount = this.accountRepository.findById(voucher.getAccountID()).get();
		currentAccount.setAmount(currentAccount.getAmount()+voucher.getVoucherAmount());
		this.accountRepository.save(currentAccount);
		return "redirect:/";
	}

}
