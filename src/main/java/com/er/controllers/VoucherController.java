package com.er.controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.er.models.User;
import com.er.models.Voucher;
import com.er.services.TransactionService;


@Controller
@RequestMapping("/voucher")
public class VoucherController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/insert")
	public String displayVoucherEntryForm(Model model, Principal principle) {
		model.addAttribute("voucher", new Voucher());
		model.addAttribute("accountList",((User)principle).getAccounts());
		model.addAttribute("actionType", "insert");
		return "voucherEntryForm";
	}
	
	@PostMapping("/insert")
	public String processVoucherEntry(@ModelAttribute Voucher voucher, Model model) {
		System.out.println("In processVoucherEntry method:");
		this.transactionService.saveTransaction(voucher);
		return "redirect:/";
	}

}
