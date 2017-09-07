package com.project1.db;


import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.project1.userandrole.model.User;

public class DatabaseFactory {
	
	public static final String DB_CONNECTION = "databaseConnection";
	public static final String INSERT_JRA_USERS = "INSERT INTO JRA_USERS values(?,?,?,?,?,?,?)";
	

	public static void addToDatabase(User user) {
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
			
			System.out.println(user.getUsername() + " has been successfully added to table row");
			
		} catch(SQLException ex) {
			System.out.println(ex);
		}
	}
	
	public static int generateRoleId(HttpServletRequest req) {
		
		try {
			ArrayList<Integer> rowList = new ArrayList<Integer>();	
			
			Connection conn = (Connection) req.getServletContext().getAttribute(DB_CONNECTION);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT COUNT(id) FROM ROLE");
			rs.next();
			
			int rowCount = rs.getInt(1);
			
			return rowCount;
		} catch(SQLException ex) {
			System.out.println("Method name : int generateRoleId()");
			System.out.println("Error : " + ex);
		}
		return 0;
	}
}
