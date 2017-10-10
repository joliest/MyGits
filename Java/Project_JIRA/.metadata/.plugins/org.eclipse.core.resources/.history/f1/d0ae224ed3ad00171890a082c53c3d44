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
	
	public int createId() {
		return 0;
	}
	
	protected abstract void setProperties();
	
	
}
