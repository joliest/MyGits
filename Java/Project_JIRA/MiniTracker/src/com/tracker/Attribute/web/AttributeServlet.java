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
		
		String category = request.getParameter("category");
		String alert = "";
		
		DatabaseManager managerTask = new AttributeDatabaseManager(request);
		AttributeDatabaseManager attributeManagerTask = (AttributeDatabaseManager) managerTask;
		
		if(category.equals("addAttribute")) {		
			
			Attribute attributeAdder = new Attribute(request);
			DatabaseManager addAttributeManager = new AttributeDatabaseManager(attributeAdder);				
			addAttributeManager.add();
			
			alert +=  attributeAdder.getName() + " is added.";
			
		} else if(category.equals("loadAttributesPanel")) {
			HashMap<Integer, String> attributeGroups = managerTask.listGroups();
			HashMap<Integer, String> attributes;
			
			for(Map.Entry<Integer, String> groupEntry : attributeGroups.entrySet()) {
				
				String groupId = groupEntry.getKey().toString();
				String groupName = groupEntry.getValue().toString();
				
				int attributeGroupId = groupEntry.getKey();
				attributes = managerTask.getMembersByGroupId(attributeGroupId);
				
				//generates <li groupId="100">GroupName</li>
				//alert += "<li groupId=\"" + groupId + "\">";
				alert += "<li>";
				alert +=  "<b groupId=\"" + groupId + "\" id=\"attributeGroupListRow\">" + groupName + "</b>";		
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
			
		} else if(category.equals("getAttributeGroup")) {
			int attributeId = getAttributeId(request);
			alert += attributeManagerTask.getAttributeGroupById(attributeId);
			
		} else if(category.equals("getAttributeName")) {
			int attributeId = getAttributeId(request);
			alert += attributeManagerTask.getAttributeNameById(attributeId);
			
		} else if(category.equals("getDataType")) {
			int attributeId = getAttributeId(request);
			alert += attributeManagerTask.getAttributeDataTypeById(attributeId);
			
		} else if(category.equals("getLength")) {
			int attributeId = getAttributeId(request);
			alert += attributeManagerTask.getAttributeLengthById(attributeId);
			
		} else if(category.equals("deleteAttribute")) {
			int attributeId = getAttributeId(request);
			alert += managerTask.remove(attributeId);
			
		}else {
			
		}		
		out.print(alert);
	}
	
	private int getAttributeId(HttpServletRequest request) {
		String attributeIdValue = request.getParameter("attributeId");
		int attributeId = Integer.parseInt(attributeIdValue);
		return attributeId;
	}
}
