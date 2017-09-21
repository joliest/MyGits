package com.project1.attribute.model;

import javax.servlet.http.HttpServletRequest;

public class Attribute {
	private String group;
	private String name;
	private String description;
	private String dataType;
	private int length;
	
	private HttpServletRequest req;
	
	public void setAttributeDetails(HttpServletRequest req) {
		this.req = req;
		group = req.getParameter("selectAttributeGroup");
		name = req.getParameter("attributeName");
		description = req.getParameter("attributeDescription");
		dataType = req.getParameter("selectAttributeType");
		
		String attributeLength = req.getParameter("attributeLength");
		length = Integer.parseInt(attributeLength);
	}
	
	public String getGroup() {
		return group;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getDataType() {
		return dataType;
	}

	public int getLength() {
		return length;
	}

	public HttpServletRequest getReq() {
		return req;
	}
	
}
