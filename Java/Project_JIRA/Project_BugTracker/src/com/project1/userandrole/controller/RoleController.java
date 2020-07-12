package com.project1.userandrole.controller;


import javax.servlet.*;
import javax.servlet.http.*;

import com.project1.db.DatabaseFactory;
import com.project1.userandrole.model.Role;

import java.io.*;
import java.sql.*;
/*
 * Bug 1: When window is refreshed, JDBC inserts another row
 */
public class RoleController extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		String roleStatus;
		
		Role role = new Role();
		role.setRoleDetails(req);
		roleStatus = DatabaseFactory.addToDatabase(role);
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println(roleStatus);
	}
}
