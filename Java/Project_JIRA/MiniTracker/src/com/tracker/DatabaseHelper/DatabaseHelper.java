package com.tracker.DatabaseHelper;

import java.sql.*;

public class DatabaseHelper {
	private static Connection connection;
	
	public DatabaseHelper(String driver, String ConnectionURL) {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(ConnectionURL, "system", "Sql12345");
			System.out.println("Database Connected");
		} catch(SQLException sEx) {
			System.out.println("Database Connection Failed: " + sEx);
		} catch(ClassNotFoundException cEx) {
			System.out.println("Class name is not valid: " + cEx);
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
