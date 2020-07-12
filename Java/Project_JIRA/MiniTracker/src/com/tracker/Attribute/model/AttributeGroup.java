package com.tracker.Attribute.model;

import javax.servlet.http.HttpServletRequest;

import com.tracker.ModuleAbstract;

public class AttributeGroup extends ModuleAbstract{

	public AttributeGroup(HttpServletRequest request) {
		super(request);
	}

	@Override
	protected void setProperties() {
		name = request.getParameter("name");
	}

}
