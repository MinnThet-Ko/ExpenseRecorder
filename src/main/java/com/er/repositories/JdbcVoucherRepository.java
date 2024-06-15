package com.er.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.er.models.Voucher;

@Repository
public class JdbcVoucherRepository implements VoucherRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insertVoucher(Voucher voucher) {
		this.jdbcTemplate.update("insert into voucher(voucherID, voucherDescription, voucherAmount, voucherDate, accountID) values (?,?,?,?,?)",
				voucher.getVoucherID(), 
				voucher.getVoucherDescription(), 
				voucher.getVoucherAmount(),
				voucher.getVoucherDate(),				
				voucher.getAccountID());
		return false;
	}

	@Override
	public boolean updateVoucher(Voucher voucher) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteVoucher(String voucherID) {
		// TODO Auto-generated method stub
		return false;
	}

}
