package com.lateral.service;

import java.math.BigDecimal;

public class Invoice {

	private String number;
	private String accountNumber;
	private BigDecimal amount;
	
	public Invoice(String number, String accountNumber, BigDecimal amount) {
		super();
		this.number = number;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
