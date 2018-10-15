package org.shyu.springboot.dao.impl;

public class InsufficientBalanceException extends Exception {
	private static final long serialVersionUID = -1169054814339837262L;
	public InsufficientBalanceException(String message) {
		super(message);
	}
}
