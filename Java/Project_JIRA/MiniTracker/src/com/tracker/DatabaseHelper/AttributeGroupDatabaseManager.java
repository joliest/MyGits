package com.tracker.DatabaseHelper;

import java.sql.*;

import com.tracker.Module;
import com.tracker.Attribute.model.AttributeGroup;

public class AttributeGroupDatabaseManager extends DatabaseManager{
	
	private AttributeGroup attributeGroup;
	
	private final static int ID = 1;
	private final static int NAME = 2;
	
	private int id;
	private String name;
	
	private final String addQuery = "INSERT INTO ATTRIBUTEGROUP VALUES(?,?)";
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
	public void remove() {
		// TODO Auto-generated method stub
		
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
		return 0;
	}

}
