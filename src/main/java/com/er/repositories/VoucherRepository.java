package com.er.repositories;

import org.springframework.data.repository.CrudRepository;

import com.er.models.Voucher;

public interface VoucherRepository extends CrudRepository<Voucher, String>{
	
}
