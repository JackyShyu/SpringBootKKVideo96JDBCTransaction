package org.shyu.springboot.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.shyu.springboot.model.Account;
import org.springframework.jdbc.core.RowMapper;

public class AccountRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Account account = new Account();
		account.setAccountNumber(resultSet.getLong("account_number"));
		account.setAccountHolderName(resultSet.getString("account_name"));
		account.setAccountType(resultSet.getString("account_type"));
		account.setBalance(resultSet.getDouble("balance"));
		return account;
	}

}
