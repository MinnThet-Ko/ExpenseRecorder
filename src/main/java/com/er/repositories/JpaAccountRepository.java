package com.er.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.er.models.Account;


@Repository
public interface JpaAccountRepository extends CrudRepository<Account, String>{
	
}
