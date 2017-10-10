package com.tracker.Attribute.model;

import javax.servlet.http.HttpServletRequest;

import com.tracker.ModuleAbstract;

public class Attribute extends ModuleAbstract{
	
	public Attribute(HttpServletRequest request) {
		super(request);
	}
	
	private String group;
	private String dataType;
	private int length;
	private int groupId;

	protected void setProperties() {
		String lengthString = request.getParameter("length");		
		group = request.getParameter("groupName");
		name = request.getParameter("name");
		dataType = request.getParameter("dataType");		
		length = Integer.parseInt(lengthString);
	}
	
	public String getDataType() {
		return dataType;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getGroupId() {
		return groupId;
	}
}

/*
	Get Group's group id
	Create GroupAttribute Module
*/