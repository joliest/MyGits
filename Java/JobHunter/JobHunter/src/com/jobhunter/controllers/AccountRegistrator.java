package com.jobhunter.controllers;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.jobhunter.components.Account;
import com.jobhunter.database.AccountDatabase;

public class AccountRegistrator extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Account account = new Account(email, password);
		AccountDatabase database = new AccountDatabase();
		
		database.add(account);
		
		RequestDispatcher view = request.getRequestDispatcher("/Profile");
		view.forward(request, response);
	}
}
