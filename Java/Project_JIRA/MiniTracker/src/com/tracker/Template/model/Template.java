package com.tracker.Template.model;

import javax.servlet.http.HttpServletRequest;

import com.tracker.ModuleAbstract;

public class Template extends ModuleAbstract{

	public Template(HttpServletRequest request) {
		super(request);
	}
	
	private int parentTemplate;

	@Override
	protected void setProperties() {
		name = request.getParameter("templateName");
		String parentTemplateRequest = request.getParameter("parentTemplate");
		//parentTemplate = Integer.parseInt(parentTemplateRequest);
	}
	
	public String getName() {
		return name;
	}
	

}
