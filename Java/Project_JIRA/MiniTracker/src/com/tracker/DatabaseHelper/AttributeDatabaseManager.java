package com.tracker.DatabaseHelper;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;

import com.tracker.Module;
import com.tracker.Attribute.model.Attribute;

public class AttributeDatabaseManager extends DatabaseManager{
	
	private Attribute attribute;
	
	private static final int ID = 1;
	private static final int GROUPID = 2;
	private static final int NAME = 3;
	private static final int DATATYPE = 4;
	private static final int LENGTH = 5;
	
	private int id;
	private int groupId;
	private String name;
	private String dataType;
	private int length;
	
	private final String addQuery = "INSERT INTO ATTRIBUTE VALUES(?,?,?,?,?)";
	private final String countRows = "SELECT * FROM ATTRIBUTE ORDER BY ID DESC";

	public AttributeDatabaseManager(Module module) {
		super(module);
		attribute = (Attribute) module;
		id = generateId();
		//groupId
		name = attribute.getName();
		dataType = attribute.getDataType();
		length = attribute.getLength();
	}
	
	@Override
	protected int generateId() {
		try {
			statement = connection.createStatement();			
			rowCount = statement.executeQuery(countRows);
			rowCount.next();			
			id = (rowCount.getInt(1)) + 1;	
			System.out.println("AttributeDatabaseManager.generateId() value is " + id);
		}  catch (SQLException sEx) {
			System.out.println("AttributeDatabaseManager.generateId() : " + sEx);
		}
		return id;
	}

	@Override
	public void add() {
		try {
			preparedStatement = connection.prepareStatement(addQuery);
			preparedStatement.setInt(ID, id);
			preparedStatement.setInt(GROUPID, 0);
			preparedStatement.setString(NAME, name);
			preparedStatement.setString(DATATYPE, dataType);
			preparedStatement.setInt(LENGTH, length);
			preparedStatement.execute();
			System.out.println("New Attribute added " + name);
		} catch (SQLException sEx) {
			System.out.println("AttributeDatabaseManager.add() : " + sEx);
		}
	}

	@Override
	public void update() {
		/*
		boolean isNumber = identifyColumnType(columnIndex);
		String updateQuery =  setUpdateQuery(columnIndex);
		
		try {
			PreparedStatement stmt = connection.prepareStatement(updateQuery);
			if(isNumber) {
				int parsedValue = Integer.parseInt(value);
				stmt.setInt(columnIndex, parsedValue);
			} else {
				stmt.setString(columnIndex, value);
			}
			stmt.execute();
		} catch (SQLException sEx) {
			System.out.println("AttributeDatabaseManager.update() : " + sEx);
		}
		*/
	}

	@Override
	public void remove() {
		
	}
	

	@Override
	public void view() {
		
	}
	
	private boolean identifyColumnType(int columnIndex) {
		boolean isNumber = false;
		
		switch(columnIndex) {
			case ID: isNumber = true;
					break;
			case GROUPID: isNumber = true;
					break;
			case NAME: isNumber = false;
					break;
			case DATATYPE: isNumber = false;
					break;
			case LENGTH: isNumber = true;
					break;
			default: isNumber = false;
					break;
		}
		System.out.println("Identified column type value is : " + isNumber);
		return isNumber;
	}

	private String setUpdateQuery(int columnIndex) {
		String updateQuery = "UPDATE ATTRIBUTE SET ";
		
		switch(columnIndex) {
			case ID: updateQuery += "ID";
					break;
			case GROUPID: updateQuery += "GROUPID";
					break;
			case NAME: updateQuery += "NAME";
					break;
			case DATATYPE: updateQuery += "DATATYPE";
					break;
			case LENGTH: updateQuery += "LENGTH";
					break;
			default: updateQuery += "INVALID"; 
					break;
		}
		
		updateQuery += "=? WHERE ID=?";
		
		System.out.println("Generated updateQuery: " + updateQuery);
		
		return updateQuery;
	}

	

	
}
