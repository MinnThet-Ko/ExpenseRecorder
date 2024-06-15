package com.er.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.er.models.Voucher;

@Repository
public interface JpaVoucherRepository extends CrudRepository<Voucher, String> {

}
