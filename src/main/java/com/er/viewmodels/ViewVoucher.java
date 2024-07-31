package com.er.viewmodels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.er.models.Account;
import com.er.models.Voucher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewVoucher {
	
	@Autowired
	private Voucher voucher;

	@Autowired
	private Account account;
}
