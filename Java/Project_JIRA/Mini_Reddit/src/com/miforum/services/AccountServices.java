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
	
	public void registerAccount() {
		database.insert(account);
	}
	
	public boolean isValid(Account account) {
		boolean isValid = false;
		String username = account.getUsername();
		String password = account.getPassword();
		return isValid;
	}
	
	public void deleteAccount() {
		
	}
	
	public void logIn() {
		
	}
	
}
