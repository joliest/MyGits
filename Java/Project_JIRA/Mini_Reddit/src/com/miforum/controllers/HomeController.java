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

public class HomeController  extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(false);
		Account activeAccount = (Account) session.getAttribute("activeAccount");
		
		if(activeAccount == null) {
			response.sendRedirect("/Mini_Reddit/login.jsp");	
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
			view.forward(request, response);
		}		
	}
}
