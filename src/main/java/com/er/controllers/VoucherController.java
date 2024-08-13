package com.er.controllers;

import java.security.Principal;
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

import com.er.models.User;
import com.er.models.Voucher;
import com.er.services.AccountService;
import com.er.services.TransactionService;
import com.er.services.VoucherService;


@Controller
@RequestMapping("/voucher")
public class VoucherController {
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private VoucherService voucherService;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/insert")
	public String displayVoucherEntryForm(Model model) {
		User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("voucher", new Voucher());
		model.addAttribute("accountList",this.accountService.getAccountsByUser(loggedInUser));
		model.addAttribute("actionType", "insert");
		return "voucherEntryForm";
	}
	
	@PostMapping("/insert")
	public String processVoucherEntry(@RequestParam(name = "transactionType") String transactionType,@ModelAttribute Voucher voucher, Model model) {
		System.out.println("In processVoucherEntry method:");
		System.out.println("Transaction type:"+transactionType);
		this.transactionService.saveTransaction(voucher, transactionType);
		return "redirect:/";
	}

}
