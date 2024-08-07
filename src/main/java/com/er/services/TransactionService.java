package com.er.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.er.models.Account;
import com.er.models.Voucher;
import com.er.repositories.AccountRepository;
import com.er.repositories.VoucherRepository;

import jakarta.transaction.Transactional;

@Service
public class TransactionService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private VoucherRepository voucherRepository;
	
	@Transactional
	public void saveTransaction(Voucher voucher) {
		Account currentAccount = voucher.getAccount();
		currentAccount.setAmount(voucher.getVoucherAmount()+currentAccount.getAmount());
		this.voucherRepository.save(voucher);
		this.accountRepository.save(currentAccount);
	}

}
