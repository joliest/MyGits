package com.project1.userandrole.model;

import java.sql.*;

public class Role {
	
	private String roleName;
	private Connection conn;
	
	
	public void createRole(String roleName) {
		this.roleName = roleName;
	}
	
	public void deleteRole(String roleName) {
		
	}
	
	//public ArrayList getRoleList(String keyword) {
		
	//}
	
	

}
