package com.project1.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.project1.userandrole.model.User;

public class DatabaseService {
	
	

	public static void addToDatabase(HttpServletRequest req, User user) {
		try {
			Connection conn = (Connection) req.getServletContext().getAttribute("databaseConnection"); 

			PreparedStatement stmt = conn.prepareStatement("INSERT INTO JRA_USERS values(?,?,?,?,?,?,?)");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getMobile());
			stmt.setString(6, user.getEmailAdd());
			stmt.setInt(7, 01);
			
			stmt.executeUpdate();
			
			System.out.println(user.getUsername() + " has been successfully added to table row");
			
		} catch(SQLException ex) {
			System.out.println(ex);
		}
	}
	
	
}
