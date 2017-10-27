package com.tracker.Attribute.web;

import javax.servlet.http.*;

import com.tracker.Attribute.model.*;
import com.tracker.DatabaseHelper.*;

import javax.servlet.*;
import java.io.*;
import java.util.*;

public class AttributeGroupServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");		
		PrintWriter out = response.getWriter();
		
		String category = request.getParameter("category");
		String alert = "";
		
		AttributeGroup attributeGroup = new AttributeGroup(request);		
		DatabaseManager managerTask = new AttributeGroupDatabaseManager(attributeGroup);
		AttributeGroupDatabaseManager attributeGroupManagerTask = (AttributeGroupDatabaseManager) managerTask;
		
		HashMap<Integer, String> attributeGroupList;
		
		if(category.equals("addAttributeGroup")) {
			
			managerTask.add();
			alert += attributeGroup.getName() + " is added.";
			
		} else if (category.equals("loadAttributeGroups")) {
			
			attributeGroupList = (HashMap<Integer, String>) attributeGroupManagerTask.getAttributeGroups();
			
			for(Map.Entry row : attributeGroupList.entrySet()) {
				
				String key = row.getKey().toString();
				String value = row.getValue().toString();
				alert += generateOptionTag(key, value);						
			}
		}
		
		out.println(alert);		
	}
	
	private String generateOptionTag(String key, String value) {
		String optionTag = "";
		optionTag += "<option attributeid=\"";
		optionTag += key;
		optionTag += "\">";
		optionTag += value;
		optionTag += "</option>";	
		return optionTag;
	}
}
