package com.tracker.Attribute.web;

import javax.servlet.http.*;

import com.tracker.Module;
import com.tracker.Attribute.model.Attribute;
import com.tracker.Attribute.model.AttributeGroup;
import com.tracker.DatabaseHelper.*;

import javax.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class AttributeServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String category = request.getParameter("category");
		String alert = "";
		
		Attribute attribute;
		DatabaseManager managerTask;
		
		AttributeGroup attributeGroup;
		
		if(category.equals("addAttribute")) {		
			
			attribute = new Attribute(request);
			managerTask = new AttributeDatabaseManager(attribute);		
			
			managerTask.add();
			
			alert +=  attribute.getName() + " is added.";
			
		} else if(category.equals("addAttributeGroup")) {
			
			attributeGroup = new AttributeGroup(request);
			managerTask = new AttributeGroupDatabaseManager(attributeGroup);
			
		} else {
			
			
			
		}
		
		
		out.print(alert);
	}
}
