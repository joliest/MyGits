package com.miforum.components;

public class Account implements Component{
	private String username;
	private String password;
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Account(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	@Override
	public String getId() {
		return username;
	}

	
	
	
}
