package com.tracker.Attribute.model;

import javax.servlet.http.HttpServletRequest;

import com.tracker.Module;
import com.tracker.ModuleAbstract;

public class Attribute extends ModuleAbstract{
	
	public Attribute(HttpServletRequest request) {
		super(request);
	}

	private String dataType;
	private int groupId;
	private int length;
	
	private HttpServletRequest request;	
	
	public int createId() {
		
		return 0;
	}

	protected void setProperties() {
		
	}

	@Override
	public HttpServletRequest getHttpRequest() {
		return request;
	}

	@Override
	protected void setDatabaseManager() {
		// TODO Auto-generated method stub
		
	}

}
