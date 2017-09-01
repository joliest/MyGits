package com.project1.db;

import java.sql.*;

public class DBConnector {	
	
	private String driverName;
	private String connectionName;
	private String username;
	private String password;
	private Connection con;
	
	public DBConnector(String driverName, String connectionName) {
		this.driverName = driverName;
		this.connectionName = connectionName;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Connection connect() {
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(connectionName, username, password);
			System.out.println("Database connection is successfull.");			
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	public void closeConnection() {
		try {
			con.close();
			System.out.println("Database successfully closed!");
		} catch (Exception ex) {
			System.out.println("Unable to close the connection");
		}
	}
	
}
