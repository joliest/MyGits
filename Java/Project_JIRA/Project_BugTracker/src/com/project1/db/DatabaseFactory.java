package com.project1.db;


import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import com.project1.userandrole.model.Role;
import com.project1.userandrole.model.User;

public class DatabaseFactory {
	
	//SQL queries
	static final String DB_CONNECTION = "databaseConnection";
	static final String INSERT_JRA_USERS = "INSERT INTO JRA_USERS values(?,?,?,?,?,?,?)";
	static final String INSERT_JRA_ROLE = "INSERT INTO JRA_ROLE values(?,?)";
	static final String CURRENT_ROLEID = "SELECT ID FROM JRA_ROLE ORDER BY ID DESC";
	static final String SELECT_ROLES = "SELECT * FROM JRA_ROLE";
	
	// overloaded method to add new USER in persistent store
	public static String addToDatabase(User user) {
		
		String status = "";
		
		try {
			
			HttpServletRequest req = user.getReq();
			Connection conn = (Connection) req.getServletContext().getAttribute(DB_CONNECTION); 
			PreparedStatement stmt = conn.prepareStatement(INSERT_JRA_USERS);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getMobile());
			stmt.setString(6, user.getEmailAdd());
			stmt.setInt(7, generateRoleId(req));
			stmt.executeUpdate();
			
			status = user.getUsername() + " is successfully added.";
			
			System.out.println(user.getUsername() + " has been successfully added to table row");
			
		} catch(SQLException ex) {
			
			status = "Something went wrong, " + user.getUsername() + " is not added.";
			
			System.out.println("Class : DatabaseFactory; Method: addToDatabase(User user");
			System.out.println("Error :" + ex);
		}
		return status;
	}
	
	// overloaded method to add new ROLE in persistent store
	public static String addToDatabase(Role role) {
		
		String status;
		int id = role.getId();
		String roleName = role.getRoleName();
		
		try {
			HttpServletRequest req = role.getReq();
			Connection conn = (Connection) req.getServletContext().getAttribute(DB_CONNECTION); 
			PreparedStatement statement = conn.prepareStatement(INSERT_JRA_ROLE);
			statement.setInt(1, id);
			statement.setString(2, roleName);
			statement.executeQuery();
			
			status = roleName + " is successfully added.";
			System.out.println(id + " " + roleName + " has been successfully added to table row");
		} catch (Exception e) {
			status = "Something went wrong, " + roleName + " is not added.";
			System.out.println(e);
		}
		return status;
	}
	
	//generate roleID using COUNT in SQL query
	public static int generateRoleId(HttpServletRequest req) {
		try {
			Connection conn = (Connection) req.getServletContext().getAttribute(DB_CONNECTION);
			Statement stmt = conn.createStatement();
			ResultSet currentRoleId = stmt.executeQuery(CURRENT_ROLEID);
			currentRoleId.next();
			
			int newRoleID = (currentRoleId.getInt(1)) + 1;
			
			return newRoleID;
		} catch(SQLException ex) {
			System.out.println("Class : DatabaseFactory Method : int generateRoleId()");
			System.out.println("Error : " + ex);
		}
		return 0;
	}
	
	public static ArrayList getRoleList(HttpServletRequest req) {
		ArrayList roleList = new ArrayList();
		try {
			Connection conn = (Connection) req.getServletContext().getAttribute(DB_CONNECTION);
			Statement stmt = conn.createStatement();
			ResultSet roleRows = stmt.executeQuery(SELECT_ROLES);
			while(roleRows.next()) {
				roleList.add(roleRows.getString(2));
			}
		} catch(SQLException ex) {
			System.out.println("Class : DatabaseFactory Method : ArrayList getRowList()");
			System.out.println("Error : " + ex);
		}
		return roleList;
	}
	
}
