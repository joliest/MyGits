package com.project1.userandrole.controller;

import javax.servlet.http.*;

import com.project1.db.DatabaseService;
import com.project1.userandrole.model.User;

import javax.servlet.*;
import java.io.*;


public class UserController extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		User user = new User();
		user.setUserDetails(req);
		
		DatabaseService.addToDatabase(req, user);
	}

}
