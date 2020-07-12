package com.project1.userandrole.model;

import javax.servlet.http.HttpServletRequest;

public class User {
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String mobile;
	private String emailAdd;
	
	private HttpServletRequest req;
	
	public User() {
		
	}

	public void setUserDetails(HttpServletRequest req) {
		this.req = req;
		username = req.getParameter("username");
		password = req.getParameter("password");
		firstName = req.getParameter("firstName");
		lastName = req.getParameter("lastName");
		mobile = req.getParameter("mobileNumber");
		emailAdd = req.getParameter("emailAddress");
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmailAdd() {
		return emailAdd;
	}

	public HttpServletRequest getReq() {
		return req;
	}
	
	
}
