package com.tracker.DatabaseHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import com.tracker.Module;
import com.tracker.Attribute.model.AttributeGroup;

public class AttributeGroupDatabaseManager extends DatabaseManager{
	
	private AttributeGroup attributeGroup;
	
	private final static int ID = 1;
	private final static int NAME = 2;
	
	private int id;
	private String name;
	
	private final String addQuery = "INSERT INTO ATTRIBUTEGROUP VALUES(?,?)";
	private final String selectQuery = "SELECT * FROM ATTRIBUTEGROUP";
	private final String countRows = "SELECT * FROM ATTRIBUTEGROUP ORDER BY ID DESC";

	public AttributeGroupDatabaseManager(Module module) {
		super(module);
		this.attributeGroup = (AttributeGroup) module;
		id = generateId();
		name = attributeGroup.getName();
	}

	@Override
	public void add() {
		try {
			preparedStatement = connection.prepareStatement(addQuery);
			preparedStatement.setInt(ID, id);
			preparedStatement.setString(NAME, name);
			preparedStatement.executeQuery();
			System.out.println("New Attribute Group added " + name);
		} catch(SQLException sEx) {
			System.out.println("AttributeGroupDatabaseManager.add() : " + sEx);
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String remove(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected int generateId() {
		try {
			statement = connection.createStatement();
			rowCount = statement.executeQuery(countRows);
			rowCount.next();
			id = (rowCount.getInt(1)) + 1;
			System.out.println("AttributeGroupDatabaseManager.generateId() value is " + id);
		} catch(SQLException sEx) {
			System.out.println("AttributeGroupDatabaseManager.generateId() : " + sEx);
		}
		return id;
	}
	
	public HashMap<Integer, String>  getAttributeGroups() {
		HashMap<Integer, String> list = new HashMap<Integer, String>();
		//ArrayList list = new ArrayList();
		ResultSet attributeGroupRow;
		try {
			statement = connection.createStatement();
			attributeGroupRow = statement.executeQuery(selectQuery);
			while(attributeGroupRow.next()) {
				
				int rowId = attributeGroupRow.getInt(1);
				String rowName = attributeGroupRow.getString(2);
				
				list.put(rowId, rowName);
			}
			System.out.println("AttributeGroupDatabaseManager.getAttributeGroups() value is " + list);
		} catch(SQLException sEx) {
			System.out.println("AttributeGroupDatabaseManager.getAttributeGroups() : " + sEx);
		}
		
		return list;
	}

	@Override
	public HashMap<Integer, String> listGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, String> getMembersByGroupId(int groupId) {
		// TODO Auto-generated method stub
		return null;
	}

}
