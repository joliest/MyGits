package com.miforum.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miforum.components.Account;
import com.miforum.database.AccountDatabase;
import com.miforum.services.AccountServices;

public class LoginAccount extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String username = request.getParameter("login_username");
		String password = request.getParameter("login_password");
		
		Account account = new Account(username, password);
		AccountDatabase database = new AccountDatabase();
		AccountServices thisAccount = new AccountServices(account, database);
		
		RequestDispatcher view;		
		
		if(thisAccount.isValid()) {
			HttpSession session = request.getSession();
			synchronized (session) {
				session.setAttribute("activeAccount", account);
			}
			response.sendRedirect("home");
		} else {
			view = request.getRequestDispatcher("/login.jsp");
			view.forward(request, response);
		}		
	}
}
