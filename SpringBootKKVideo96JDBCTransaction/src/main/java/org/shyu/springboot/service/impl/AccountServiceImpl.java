package org.shyu.springboot.service.impl;

import org.shyu.springboot.dao.impl.AccountDaoImpl;
import org.shyu.springboot.dao.impl.InsufficientBalanceException;
import org.shyu.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDaoImpl accountDaoImpl;

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=InsufficientBalanceException.class)
	public void transferBalance(long fromAccount, long toAccount, double amount) throws InsufficientBalanceException {
		accountDaoImpl.withdraw(fromAccount, toAccount, amount);		
		accountDaoImpl.deposit(fromAccount, toAccount, amount);
	}

}
