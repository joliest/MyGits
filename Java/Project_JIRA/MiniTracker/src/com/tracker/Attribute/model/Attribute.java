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
	
	public int createId() {
		
		return 0;
	}

	protected void setProperties() {
		group = request.getParameter("group");
		name = request.getParameter("name");
		dataType = request.getParameter("dataType");
		length = Integer.parseInt(request.getParameter("length"));
		System.out.println("Following properties are added" + group + " " + name + " " +  dataType + " " +  length);
	}

	@Override
	public HttpServletRequest getHttpRequest() {
		return request;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDataType() {
		return dataType;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getId() {
		return id;
	}
	
	public int getGroupId() {
		return groupId;
	}
}

/*
	Get Group's group id
	Create GroupAttribute Module
*/