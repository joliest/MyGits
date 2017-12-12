package com.tracker.Template.web;

import javax.servlet.http.*;

import com.tracker.Module;
import com.tracker.DatabaseHelper.AttributeDatabaseManager;
import com.tracker.DatabaseHelper.DatabaseManager;
import com.tracker.DatabaseHelper.TemplateDatabaseManager;
import com.tracker.Template.model.Template;

import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TemplateServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String category = request.getParameter("category");
		String message = "";
		
		if(category.equals("addTemplate")) {
			Template template = new Template(request);
			DatabaseManager databaseManager = new TemplateDatabaseManager(template);
			databaseManager.add();
			
			message += "Successfully added"; 
		} 

		if(category.equals("loadTemplateList")) {
			DatabaseManager managerTask = new TemplateDatabaseManager(request);
			HashMap<Integer, String> templateList = managerTask.listGroups();
			
			for(Map.Entry<Integer, String> entry : templateList.entrySet()) {
				int id = entry.getKey();
				String name = entry.getValue();
				
				// generates <li id="templateListRow" templateId = "id"> name </li>
				message += "<li id=\"templateListRow\" templateId=\"" + id + "\">";
				message += name;
				message +="</li> \n";
			}
		} else if(category.equals("loadAttributeGroups")) {
			DatabaseManager attributeGroup = new AttributeDatabaseManager(request);
			HashMap<Integer, String> groupList = attributeGroup.listGroups();
			for(Map.Entry<Integer, String> entry : groupList.entrySet()) {
				
				int key = entry.getKey();
				String value = entry.getValue();
				
				//generates <b id="attributeGroupList" attributeGroupId="1"> General </b>
				message += "<b id=\"attributeGroupList\" attributeGroupId=\"" + key + "\">";
				message += value;
				message += "</b> <br>";
				message += "<div attributeGroupId=\"" + key + "\"></div> \n"; // this is where the attributes appear
			}			
		} else if(category.equals("getAttributeList")) {
			
			String attributeGroup = request.getParameter("attributeGroupId");
			int attributeGroupId = Integer.parseInt(attributeGroup);
			
			DatabaseManager attributes = new AttributeDatabaseManager(request);
			HashMap<Integer, String> attributeList = attributes.getMembersByGroupId(attributeGroupId);
			
			message += "<table> \n";
			for(Map.Entry<Integer, String> entry : attributeList.entrySet()) {
				int key = entry.getKey();
				String value = entry.getValue();
				
				//generates : <li><input type="checkbox" attributeGroupId="12" attributeId="11"> Name </li>		
				message += "<tr>";
				message += "<td> &nbsp; <input type=\"checkbox\" attributeGroupId=\"" + attributeGroupId + "\"";
				message += " attributeId=\"" + key + "\">" + value + "</td> \n";
				message += "</tr>";
			}
			message += "</table> \n";	
		} else if(category.equals("addTemplateAttribute")) {
			//getting the array of attributeIds from selected checkboxes selectedCheckboxes[]
			String[] attributes = request.getParameterValues("selectedCheckboxes[]");
			String templateId = request.getParameter("templateId");
			ArrayList<String> attributeList = new ArrayList<String>();
			
			int id = Integer.parseInt(templateId);
			
			for(int i = 0; i < attributes.length; i++) {
				attributeList.add(attributes[i]);
				System.out.println("TemplateServlet added " + attributes[i] + " in ArrayList");
			}
			
			TemplateDatabaseManager databaseManager = new TemplateDatabaseManager(request);
			databaseManager.addTemplateAttributes(id, attributeList);
		}
		
		System.out.println(message);
		out.println(message);
	}
}



























