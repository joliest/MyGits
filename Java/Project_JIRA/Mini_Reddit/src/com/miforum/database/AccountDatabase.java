package com.miforum.database;

import java.sql.*;

import com.miforum.components.Account;
import com.miforum.components.Component;

public class AccountDatabase extends Database{
	
	private Account account;

	public AccountDatabase() {
		super();
	}

	@Override
	public void insert(Component component) {
		account = (Account) component;
		
	}

	@Override
	public String select(Component component) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Component component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Component oldComponent, Component newComponent) {
		// TODO Auto-generated method stub
		
	}
	
}
