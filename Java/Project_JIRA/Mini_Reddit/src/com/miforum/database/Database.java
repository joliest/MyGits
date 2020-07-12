package com.miforum.database;

import java.sql.*;

import com.miforum.components.Component;

public abstract class Database {
	
	protected Connection connection = null;
	protected Statement statement = null;
	protected PreparedStatement preparedStatement = null;
	protected ResultSet resultSet = null;
	
	public Database() {		 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "Sql12345");
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}
	
	public abstract void insert(Component component);
	public abstract String select(Component component, int numberOfRows);
	public abstract String selectOne(Component component);
	public abstract void delete(Component component);
	public abstract void update(Component oldComponent, Component newComponent);
	
	protected void preparedStatement(PreparedStatement statement) {
		try {
			PreparedStatement stmt = (PreparedStatement) statement;
			stmt.execute();
		} catch(SQLException ex) {
			System.out.println("Database.preparedStatement() : " + ex);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch(SQLException ex) {
				System.out.println("Database.preparedStatement() : " + ex);
			}		
			
			}
	}
	
	protected int generateId(String countScript) {
		
		int id = 0;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = connection.createStatement();			
			rs = stmt.executeQuery(countScript);
			if(rs.next()) {
				id = (rs.getInt(1)) + 1;	
			} 
		}  catch (SQLException sEx) {
			System.out.println("Database.generateId() : " + sEx);
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}
	
}
