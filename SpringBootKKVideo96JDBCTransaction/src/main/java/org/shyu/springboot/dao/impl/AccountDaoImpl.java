package org.shyu.springboot.dao.impl;

import java.util.List;

import org.shyu.springboot.dao.AccountDao;
import org.shyu.springboot.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void withdraw(long fromAccount, long toAccount, double amount) throws InsufficientBalanceException {
		Account accountFromDB = getAccountByNumber(fromAccount);
		System.out.println("Balance: " + accountFromDB.getBalance());
		double balance = accountFromDB.getBalance() - amount;
		if (balance > 0) {
			int result = updateBalanceByNumber(fromAccount, balance);
			System.out.println("Update Result: " + result);
		} else {
			throw new InsufficientBalanceException("Insufficient Account Balance");
		}
	}

	@Override
	public void deposit(long fromAccount, long toAccount, double amount) {
		Account accountFromDB = getAccountByNumber(toAccount);
		System.out.println("Balance: " + accountFromDB.getBalance());
		double balance = accountFromDB.getBalance() + amount;
		int result = updateBalanceByNumber(toAccount, balance);
		System.out.println("Update Result: " + result);
	}
	
	private Account getAccountByNumber(long fromAccount) {
		String SQL = "select * from bank_account where account_number = ?";
		List<Account> accounts = jdbcTemplate.query(SQL, new AccountRowMapper(), fromAccount);
		return accounts.get(0);
	}
	
	private int updateBalanceByNumber(long accountNumber, double balance) {
		String SQL = "update bank_account set balance = ? where account_number = ?";
		return jdbcTemplate.update(SQL, balance, accountNumber);
		
	}

}
