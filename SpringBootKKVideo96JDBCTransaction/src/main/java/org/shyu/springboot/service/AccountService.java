package org.shyu.springboot.service;

import org.shyu.springboot.dao.impl.InsufficientBalanceException;

public interface AccountService {
	public abstract void transferBalance(long fromAccount, long toAccount, double amount) throws InsufficientBalanceException;
}
