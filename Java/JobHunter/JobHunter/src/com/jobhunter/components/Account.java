package com.jobhunter.components;

public class Account {
	private String emailAddress;
	private String password;
	private Profile profile = null;

	public Account(String emailAddress, String password) {
		this.emailAddress = emailAddress;
		this.password = password;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	
}
