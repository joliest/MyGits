package com.project1.userandrole.model;

import javax.servlet.http.HttpServletRequest;

import com.project1.db.DatabaseFactory;

public class Role {
	
	private final String ROLE_NAME = "roleName";
	
	private String roleName;
	private int id;
	private HttpServletRequest req;
	
	public void setRoleDetails(HttpServletRequest req) {
		this.req = req;
		roleName = req.getParameter(ROLE_NAME);
		id = DatabaseFactory.generateRoleId(req);
	}
	
	public int getId() {
		return id;
	}
	
	public HttpServletRequest getReq() {
		return req;
	}
	
	public String getRoleName() {
		return roleName;
	}
}
