package com.er.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.er.models.Account;

public interface AccountRepository{
	
	public boolean saveAccount(Account account);
	public boolean updateAccount(Account account);
	public boolean deleteAccount(String accountID);
	public List<Account> getAllAccount();
	public Account getAccountByID(String accountID);
	public boolean updateAmount(String accountID, long amount);

}
