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
	
	public boolean isValid() {
		boolean isValid = false;
		if(account.getPassword() != null) {
			isValid = database.isValid(account);
		}
		return isValid;
	}
	
	public void deleteAccount() {
		
	}
	
	public void logIn() {
		
	}
	
}
