package com.er.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.er.models.Voucher;
import com.er.repositories.VoucherRepository;

import jakarta.transaction.Transactional;

@Service
public class VoucherService {
	
	@Autowired
	private VoucherRepository voucherRepository;
	
	@Autowired
	private AccountService accountService;
	
	@Transactional
	public void insertVoucher(Voucher voucher) {
		this.voucherRepository.save(voucher);
	}
	
	

}
