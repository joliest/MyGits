package com.tracker.Attribute.web;

import javax.servlet.http.*;

import com.tracker.Attribute.model.Attribute;
import com.tracker.DatabaseHelper.*;

import javax.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class AttributeServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Attribute attribute = new Attribute(request);
		DatabaseManager databaseManager = new AttributeDatabaseManager(attribute);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String category = request.getParameter("category");
		
		if(category.equals("add")) {					
			databaseManager.add();
		}
		
		String status = "";
		
		out.print("The status is " + status);
	}
}
