package com.miforum.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miforum.components.Account;
import com.miforum.database.AccountDatabase;
import com.miforum.services.AccountServices;

public class AccountRegistrator extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Account account = new Account(username, password);
		AccountDatabase database = new AccountDatabase();
		AccountServices services = new AccountServices(account, database);
		
		services.registerAccount();
		
		HttpSession session = request.getSession();
		synchronized (session) {
			session.setAttribute("activeAccount", account);
		}
		

		RequestDispatcher view = request.getRequestDispatcher("/profile.jsp");		
		view.forward(request, response);
	}
}
