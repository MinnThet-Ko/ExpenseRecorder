package com.er.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.er.models.Account;

@Repository
public class JdbcAccountRepository implements AccountRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean saveAccount(Account account) {
		this.jdbcTemplate.update("insert into account (accountID, accountName, amount) values (?,?,?)", account.getAccountID(), account.getAccountName(), account.getAmount());
		return true; 
	}

	@Override
	public List<Account> getAllAccount() {		
		return this.jdbcTemplate.query("select * from account order by accountName", this::accountRowMapper);
	}

	@Override
	public Account getAccountByID(String accountID) {
		return (Account) this.jdbcTemplate.query("select * from account where accountID = ?", new Object[]{accountID}, new BeanPropertyRowMapper<>(Account.class)).get(0);
	}

	public Account accountRowMapper(ResultSet resultSet, int index) throws SQLException {
		return new Account(resultSet.getString("accountID"), resultSet.getString("accountName"), 
				resultSet.getLong("amount"));
	}

	@Override
	public boolean updateAccount(Account account) {
		this.jdbcTemplate.update("update account set accountName = ?, amount = ? where accountID = ?", account.getAccountName(), account.getAmount(), account.getAccountID());
		return true;
	}

	@Override
	public boolean deleteAccount(String accountID) {
		this.jdbcTemplate.update("delete from account where accountID = ?", accountID);
		return true;
	}

	@Override
	public boolean updateAmount(String accountID, long amount) {
		this.jdbcTemplate.update("update account set amount = amount + ? where accountID = ?", amount, accountID);
		return true;
	}
}
