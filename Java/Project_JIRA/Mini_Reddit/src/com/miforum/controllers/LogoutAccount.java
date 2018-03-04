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

public class LogoutAccount  extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		RequestDispatcher view = request.getRequestDispatcher("/login");
		view.include(request, response);
		
		out.print("You have log out");
		
		
		
	}
}
