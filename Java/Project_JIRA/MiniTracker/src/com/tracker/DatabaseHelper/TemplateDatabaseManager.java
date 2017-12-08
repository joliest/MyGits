package com.tracker.DatabaseHelper;

import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.tracker.Module;
import com.tracker.Template.model.Template;

public class TemplateDatabaseManager extends DatabaseManager{
	
	private int id;
	private int parentTemplate;
	private String name;
	
	private final String countRows = "SELECT * FROM TEMPLATE ORDER BY ID DESC";
	private final String addTemplate = "INSERT INTO TEMPLATE VALUES(?,?)";

	public TemplateDatabaseManager(Module module) {
		super(module);
		Template template = (Template) module;
		name = template.getName();
		id = generateId();
		//parentTemplate = template.getParentTemplate();
	}
	
	public TemplateDatabaseManager(HttpServletRequest request) {
		super(request);
	}

	@Override
	public void add() {
		try {
			preparedStatement = connection.prepareStatement(addTemplate);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.executeQuery();
			System.out.println("Successfully added " + name + " in TEMPLATE table");
		} catch(SQLException sEx) {
			System.out.println("TemplateDatabaseManager.add() : " + sEx);
		}
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
	public HashMap<Integer, String> listGroups() {
		HashMap<Integer, String> list = new HashMap<Integer, String>();
		try {
			statement = connection.createStatement();
			rowCount = statement.executeQuery(countRows);
			while(rowCount.next()) {
				int key = rowCount.getInt(1);
				String value = rowCount.getString(2);
				list.put(key, value);
				System.out.println("List successfully created");
			}
			
		} catch(SQLException sEx) {
			System.out.println("TemplateDatabaseManager.listGroups() : " + sEx);
		}
		return list;
	}

	@Override
	public HashMap<Integer, String> getMembersByGroupId(int groupId) {
		// TODO Auto-generated method stub
		return null;
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

}
