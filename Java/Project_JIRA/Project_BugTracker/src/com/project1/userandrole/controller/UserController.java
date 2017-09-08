package com.project1.userandrole.controller;

import javax.servlet.http.*;

import com.project1.db.DatabaseFactory;
import com.project1.userandrole.model.User;
import javax.servlet.*;
import java.io.*;


public class UserController extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		String userStatus;
		
		User user = new User();
		user.setUserDetails(req);
		userStatus = DatabaseFactory.addToDatabase(user);
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println(userStatus);
	}

}
