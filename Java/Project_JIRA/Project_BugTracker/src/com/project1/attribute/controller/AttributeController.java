package com.project1.attribute.controller;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.project1.attribute.model.Attribute;
import com.project1.db.DatabaseFactory;

public class AttributeController extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		Attribute attribute = new Attribute();
		
		attribute.setAttributeDetails(req);
		String status = DatabaseFactory.addToDatabase(attribute);
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println(status);
		
	}
}
