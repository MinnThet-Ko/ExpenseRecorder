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
	public void saveTransaction(Voucher voucher, String transactionType) {
		Account currentAccount = voucher.getAccount();
		if(transactionType.equals("withdraw")) {
			voucher.setVoucherAmount(-1 * voucher.getVoucherAmount());
		}
		currentAccount.setAmount(voucher.getVoucherAmount()+currentAccount.getAmount());
		this.voucherRepository.save(voucher);
		this.accountRepository.save(currentAccount);
	}

}
