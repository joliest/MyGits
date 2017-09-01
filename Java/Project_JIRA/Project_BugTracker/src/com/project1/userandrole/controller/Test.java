package com.project1.userandrole.controller;


import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;

public class Test extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		ServletContext sc = req.getServletContext();
		Connection conn = (Connection) sc.getAttribute("databaseConnection");
		
		String idString = req.getParameter("roleID");
		int id = Integer.parseInt(idString);
		
		String roleName = req.getParameter("roleName");
		
		try {
			PreparedStatement statement = conn.prepareStatement("insert into ROLE values(?,?)");
			statement.setInt(1, id);
			statement.setString(2, roleName);
			statement.executeQuery();
			System.out.println(id + " " + roleName + " are successfully inserted in Role table");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//RequestDispatcher view = req.getRequestDispatcher("web/admin/Admin.jsp");
		//view.forward(req, res);
	}
}
