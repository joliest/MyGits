package com.miforum.database;

import java.sql.*;

import com.miforum.components.Account;
import com.miforum.components.Component;

public class AccountDatabase extends Database{
	
	private Account account;
	
	private static final String INSERT = "INSERT INTO ACCOUNT VALUES(?, ?)";
	private static final String SELECT_BY_USERNAME = "SELECT * FROM ACCOUNT WHERE USERNAME=";

	public AccountDatabase() {
		super();
	}

	@Override
	public void insert(Component component) {
		
		account = (Account) component;
		
		String username = account.getUsername();
		String password = account.getPassword();
		
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement(preparedStatement);
		} catch (SQLException sEx) {
			System.out.println("AccountDatabase.insert() : " + sEx);
		}
	}


	@Override
	public void delete(Component component){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Component oldComponent, Component newComponent){
		// TODO Auto-generated method stub
		
	}
	
	public boolean isValid(Component component) {
		
		boolean isValid = false;
		
		account = (Account) component; 
		
		String accountUsername = account.getUsername();
		String accountPassword = account.getPassword();
		
		String sqlUsername = "";
		String sqlPassword = "";
		
		try{
			statement = connection.createStatement();
			resultSet = statement.executeQuery( SELECT_BY_USERNAME + "'" + accountUsername + "'");
			if(resultSet.next()) {
				sqlUsername = resultSet.getString(1);
				sqlPassword = resultSet.getString(2);
			}
		} catch(SQLException sEx) {
			System.out.println("AccountDatabase.isValid() : " + sEx);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException sEx) {
				System.out.println("AccountDatabase.isValid() : " + sEx);
			}		
		}

		if(accountUsername.equals(sqlUsername) && accountPassword.equals(sqlPassword)) {
			isValid = true;
		}
		
		return isValid;
	}

	@Override
	public String select(Component component, int numberOfRows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectOne(Component component) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
