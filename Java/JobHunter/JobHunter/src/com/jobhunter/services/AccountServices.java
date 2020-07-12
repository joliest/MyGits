package com.jobhunter.services;

import com.jobhunter.components.Account;
import com.jobhunter.components.Profile;
import com.jobhunter.database.AccountDatabase;

public class AccountServices {
	
	private AccountDatabase database;
	
	public boolean authenticate(Account account) {
		String email = account.getEmailAddress();
		String password = account.getPassword();
		
		database = new AccountDatabase();
		Account accountFromDatabase = database.getAccountByEmailAddress(email);
		String emailFromDatabase = accountFromDatabase.getEmailAddress();
		String passwordFromDatabase = accountFromDatabase.getPassword();
		
		if(email.equals(emailFromDatabase)) {
			if(password.equals(passwordFromDatabase)) {
				return true;
			}
		}
		return false;
	}

	public boolean profileNotNull(Account account) {
		String email = account.getEmailAddress();
		
		database = new AccountDatabase();
		
		Account accountFromDatabase = database.getAccountByEmailAddress(email);
		Profile accountProfile = accountFromDatabase.getProfile();
		
		if(accountProfile!=null) {
			return true;
		}
		
		return false;
	}
}
