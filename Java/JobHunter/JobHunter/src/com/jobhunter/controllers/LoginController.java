package com.jobhunter.controllers;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.jobhunter.components.Account;
import com.jobhunter.services.AccountServices;

public class LoginController {
	/*
	 * Controller creates a session after successfully loggin
	 * When a controller detects that there's no existing profile
	 * in a logged account, it will ask user to create one. 
	 * It will redirect to existing profile if otherwise.
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String emailFromClient = request.getParameter("email");
		String passwordFromClient = request.getParameter("password");
		
		String errorMessage = "Invalid email address and password";
		
		Account account = new Account(emailFromClient, passwordFromClient);
		AccountServices services = new AccountServices();
		
		boolean validAccount = services.authenticate(account);
		
		if(validAccount) {
			HttpSession session = request.getSession();
			session.setAttribute("account", account);
			if(services.profileNotNull(account)) {
				response.sendRedirect("/Profile.jsp");	
			} else {
				response.sendRedirect("/CreateProfile.jsp");	
			}
		} else {
			out.println(errorMessage);
		}	
	}
}
