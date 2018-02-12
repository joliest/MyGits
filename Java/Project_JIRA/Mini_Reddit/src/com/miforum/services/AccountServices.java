package com.miforum.services;

import com.miforum.components.Account;
import com.miforum.database.AccountDatabase;

/*
 	This class allows Account to communicate to database
 */
public class AccountServices {
	
	private Account account;
	private AccountDatabase database;
	
	public AccountServices(Account account, AccountDatabase database) {
		this.account = account;
		this.database = database;
	}
	
	public void addAccount() {
		
	}
	
	public boolean isValid(Account account) {
		boolean isValid = false;
		
		return isValid;
	}
	
	public void deleteAccount() {
		
	}
	
	public void logIn() {
		
	}
	
}
