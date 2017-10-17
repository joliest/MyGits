package com.tracker.DatabaseHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

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
	private final String selectAllGroups = "SELECT * FROM ATTRIBUTEGROUP";
	private final String selectAttributesByGroupId = "SELECT * FROM ATTRIBUTE WHERE GROUPID=";

	public AttributeDatabaseManager(Module module) {
		super(module);
		attribute = (Attribute) module;
		id = generateId();
		groupId = attribute.getGroupId();
		name = attribute.getName();
		dataType = attribute.getDataType();
		length = attribute.getLength();
	}
	
	public AttributeDatabaseManager(HttpServletRequest request) {
		super(request);
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
			preparedStatement.setInt(GROUPID, groupId);
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
	
	@Override
	public HashMap<Integer, String> listGroups() {

		int groupId;
		String groupName;
		
		HashMap<Integer, String> list = new HashMap<Integer, String>();
		
		ResultSet row;
		
		try {
			statement = connection.createStatement();
			row = statement.executeQuery(selectAllGroups);
			while(row.next()) {
				groupId = row.getInt(1);
				groupName = row.getString(2);
				list.put(groupId, groupName);
			}
			System.out.println("Listed Attribute Groups ");
		} catch(SQLException sEx) {
			System.out.println("AttributeDatabaseManager.getGroups() : " + sEx);
		}
		return list;		
	}

	@Override
	public HashMap<Integer, String> getMembersByGroupId(int groupId) {
		
		int attributeId;
		String attributeName;
		
		HashMap<Integer, String> list = new HashMap<Integer, String>();	
		
		ResultSet row;
		
		try {
			statement = connection.createStatement();
			row = statement.executeQuery(selectAttributesByGroupId + groupId);
			while(row.next()) {
				attributeId = row.getInt(1);
				attributeName = row.getString(3);
				list.put(attributeId, attributeName);
			}
			System.out.println("Listed Attributes of Group ID: " + groupId);
		}catch(SQLException sEx) {
			System.out.println("AttributeDatabaseManager.getMembersByGroupId() : " + sEx);
		}
		
		return list;		
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
