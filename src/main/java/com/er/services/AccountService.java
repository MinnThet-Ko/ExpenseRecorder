package com.er.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.er.models.Account;
import com.er.models.User;
import com.er.repositories.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public Set<Account> getAccountsByUser(User user){
		return this.accountRepository.findByUser(user);
	}
	
	
	

}
