package com.er.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.er.models.Account;
import com.er.models.User;

import java.util.List;


@Repository
public interface AccountRepository extends CrudRepository<Account, String>{
	
	public Set<Account> findAll();
	public Set<Account> findByUser(User user);

}
