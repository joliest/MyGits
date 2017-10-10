package com.tracker;

import javax.servlet.http.HttpServletRequest;

public abstract class ModuleAbstract implements Module{
	
	protected HttpServletRequest request;
	protected int id;
	protected String name;
	
	public ModuleAbstract(HttpServletRequest request) {
		setHttpRequest(request);
	}
	
	public void setHttpRequest(HttpServletRequest request) {
		this.request = request;
		setProperties();
	}
	
	public HttpServletRequest getHttpRequest() {
		return request;
	}
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	
	protected abstract void setProperties();
	
	
}
