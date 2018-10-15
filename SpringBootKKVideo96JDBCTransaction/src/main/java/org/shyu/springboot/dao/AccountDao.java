package org.shyu.springboot.dao;

import org.shyu.springboot.dao.impl.InsufficientBalanceException;

public interface AccountDao {
	public abstract void withdraw(long fromAccount, long toAccount, double amount) throws InsufficientBalanceException;
	public abstract void deposit(long fromAccount, long toAccount, double amount);
}
