package com.jobhunter.database;

import java.sql.SQLException;

import com.jobhunter.components.Account;
import com.jobhunter.components.Profile;

public class AccountDatabase extends Database{
	
	private static final String INSERT = "INSERT INTO ACCOUNT_JH VALUES(?,?)";
	private static final String SELECT_ACCOUNT_BY_EMAIL = "SELECT * FROM ACCOUNTJH WHERE EMAIL=?";
	private static final String PERSONAL_PROFILE_BY_EMAIL = "SELECT * FROM ACCOUNT_PERSONAL WHERE EMAIL=?";
	
	public void add(Account account) {
		String email = account.getEmailAddress();
		String password = account.getPassword();
		
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			preparedStatement.execute();
		} catch (SQLException sEx) {
			System.out.println("AccountDatabase.add(Account) : " + sEx);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/*
	public Profile getProfileByEmailAddress(String email) {
		try {
			preparedStatement = connection.prepareStatement(PERSONAL_PROFILE_BY_EMAIL);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				String email_add = resultSet.getString(1);
				String password = resultSet.getString(2);
				Account newAccount = new Account(email_add, password);
				return newAccount;
			}
			
		} catch (SQLException sEx) {
			System.out.println("AccountDatabase.add(Account) : " + sEx);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
*/
	public Account getAccountByEmailAddress(String email) {
		
		Account newAccount = null;
		Profile accountProfile = null;
		
		try {
			preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_EMAIL);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				String email_add = resultSet.getString(1);
				String password = resultSet.getString(2);
				newAccount = new Account(email_add, password);
				accountProfile = getProfileByEmailAddress(email);
			}
			
			return newAccount;
			
		} catch (SQLException sEx) {
			System.out.println("AccountDatabase.getAccountByEmailAddress(String) : " + sEx);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return newAccount;
	}
	
	public Profile getProfileByEmailAddress(String email) {
		try {
			preparedStatement = connection.prepareStatement(PERSONAL_PROFILE_BY_EMAIL);
			
			
		} catch (SQLException sEx) {
			System.out.println("AccountDatabase.getProfileByEmailAddress(String) : " + sEx);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
