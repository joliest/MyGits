package com.project1.userandrole.controller;


import javax.servlet.*;
import javax.servlet.http.*;

import com.project1.db.DatabaseFactory;

import java.io.*;
import java.sql.*;
/*
 * Bug 1: When window is refreshed, JDBC inserts another row
 */
public class RoleController extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		ServletContext sc = req.getServletContext();
		Connection conn = (Connection) sc.getAttribute("databaseConnection");
		
		int id = DatabaseFactory.generateRoleId(req);
		
		String roleName = req.getParameter("roleName");
		
		try {
			PreparedStatement statement = conn.prepareStatement("insert into ROLE values(?,?)");
			statement.setInt(1, id);
			statement.setString(2, roleName);
			statement.executeQuery();
			System.out.println(id + " " + roleName + " is successfully inserted in Role table");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		RequestDispatcher view = req.getRequestDispatcher("web/admin/Admin.jsp");
		view.forward(req, res);
	}
}
