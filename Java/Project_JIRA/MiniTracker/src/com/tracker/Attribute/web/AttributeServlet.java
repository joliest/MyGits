package com.tracker.Attribute.web;

import javax.servlet.http.*;

import com.tracker.Module;
import com.tracker.Attribute.model.Attribute;
import com.tracker.Attribute.model.AttributeGroup;
import com.tracker.DatabaseHelper.*;

import javax.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class AttributeServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		List htmlTags = new ArrayList();
		
		String category = request.getParameter("category");
		String alert = "";
		
		HashMap<Integer, String> attributeGroupList;
		
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
			
			managerTask.add();
			
			alert += attributeGroup.getName() + " is added.";
			
		}  else if(category.equals("loadAttributeGroups")) {
			
			attributeGroup = new AttributeGroup(request);
			managerTask = new AttributeGroupDatabaseManager(attributeGroup);
			
			//String attributeGroupOptionTags = "";
			
			AttributeGroupDatabaseManager attributeGroupManagerTask = (AttributeGroupDatabaseManager) managerTask;
			attributeGroupList = (HashMap<Integer, String>) attributeGroupManagerTask.getAttributeGroups();
			for(Map.Entry row : attributeGroupList.entrySet()) {
				//TODO: generates <option> tag with 'attributeid' attribute
				String key = row.getKey().toString();
				String value = row.getValue().toString();
				alert += generateOptionTag(key, value);				
			}	
			
		} else if(category.equals("loadAttributesPanel")) {
			
			managerTask = new AttributeDatabaseManager(request);
			
			HashMap<Integer, String> attributeGroups = managerTask.listGroups();
			HashMap<Integer, String> attributes;

			
			for(Map.Entry<Integer, String> groupEntry : attributeGroups.entrySet()) {
				
				String groupId = groupEntry.getKey().toString();
				String groupName = groupEntry.getValue().toString();
				
				int attributeGroupId = groupEntry.getKey();
				attributes = managerTask.getMembersByGroupId(attributeGroupId);
				
				//generates <li groupId="100">GroupName</li>
				alert += "<li groupId=\"" + groupId + "\">";
				alert += groupName;		
				alert += "<ul>";
				for(Map.Entry<Integer, String> entry : attributes.entrySet()) {
					String id = entry.getKey().toString();
					String attributeName = entry.getValue().toString();
					
					//generates <li attributeId="1001">AttributeName</li>
					alert += "<li id=\"attributeListRow\" attributeId=\"" + id + "\">";
					alert += attributeName;
					alert += "</li>";
				}
				alert += "</ul>";
				alert += "</li>";
			}
			
		} else {
			
			
			
			/*
			htmlTags.add("Hello World");
			htmlTags.add("Hello World2");
			request.setAttribute("htmlTags", htmlTags);

			request.setAttribute("htmlTags", "htmlTags");
			*/
		}		
		out.print(alert);
		
		/*
		RequestDispatcher view = request.getRequestDispatcher("/Attribute.jsp");
		view.forward(request, response);
		*/
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
