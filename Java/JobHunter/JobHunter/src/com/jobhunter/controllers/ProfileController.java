package com.jobhunter.controllers;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.jobhunter.components.Account;
import com.jobhunter.database.AccountDatabase;

public class ProfileController extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
	}
}
