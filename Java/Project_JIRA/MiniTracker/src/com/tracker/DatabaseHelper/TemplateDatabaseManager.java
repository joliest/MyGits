package com.tracker.DatabaseHelper;

import java.sql.SQLException;
import java.util.ArrayList;
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
	private final String addTemplateAttribute = "INSERT INTO TEMPLATE_ATTRIB VALUES(?,?,?)";
	//private final String selectTemplateAttribute = "SELECT ATTRIBUTE_ID FROM TEMPLATE_ATTRIB WHERE TEMPLATE_ID =";
	private final String selectTemplateAttribute = "SELECT Attr.GROUPID, Attr.ID FROM ATTRIBUTE Attr INNER JOIN TEMPLATE_ATTRIB tempAttr ON Attr.ID = tempAttr.ATTRIBUTE_ID WHERE tempAttr.TEMPLATE_ID =";
	private final String selectTemplateAttributeGroup = "SELECT GROUPID FROM ATTRIBUTE Attr INNER JOIN TEMPLATE_ATTRIB tempAttr ON Attr.ID = tempAttr.ATTRIBUTE_ID WHERE tempAttr.TEMPLATE_ID =";
	private final String orderByGroupId = " ORDER BY GROUPID";
	private final String groupByGroupId = " GROUP BY GROUPID";

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
	
	//get a map of attributeIds and AttributeGroups 
	public HashMap<Integer, Integer> getAttributesByTemplateId(int id) {
		HashMap<Integer, Integer> attributeList = new HashMap<Integer, Integer>();
		try {
			statement = connection.createStatement();
			rowCount = statement.executeQuery(selectTemplateAttribute + id + orderByGroupId);
			while(rowCount.next()) {
				int attributeId = rowCount.getInt(2);
				int attributeGroup = rowCount.getInt(1);
				attributeList.put(attributeId, attributeGroup);
				//System.out.println(attributeId + " : " + attributeGroup);
			}
			System.out.println("Successfully created attribute list");
		} catch(SQLException sEx) {
			System.out.println("TemplateDatabaseManager.getAttributesByTemplateId() : " + sEx);
		}
		return attributeList;
	}
	
	//get the list of attribute groups available in the specified template id
	public ArrayList<Integer> getAttributeGroupsByTemplateId(int id) {
		ArrayList<Integer> attributeGroupList = new ArrayList<Integer>();
		try {
			statement = connection.createStatement();
			rowCount = statement.executeQuery(selectTemplateAttributeGroup + id + groupByGroupId + orderByGroupId);
			while(rowCount.next()) {
				int row = rowCount.getInt(1);
				attributeGroupList.add(row);
			}
			System.out.println("Successfully created attribute group list");
		} catch(SQLException sEx) {
			System.out.println("TemplateDatabaseManager.getAttributeGroupsByTemplateId() : " + sEx);
		}
		return attributeGroupList;
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
	
	public void addTemplateAttributes(int templateId, ArrayList<String> attributes) {
		ArrayList<String> filteredAttributeList = removeDuplicate(templateId, attributes);
		String defaultValue = "";

		for(int i = 0; i < filteredAttributeList.size(); i++) {
			int attributeId = Integer.parseInt(filteredAttributeList.get(i));
			try {
				preparedStatement = connection.prepareStatement(addTemplateAttribute);
				preparedStatement.setInt(1, templateId);
				preparedStatement.setInt(2, attributeId);
				preparedStatement.setString(3, defaultValue);
				preparedStatement.executeQuery();
				System.out.println("Successfully added attributeId " + attributeId + " in templateId " + templateId);
			} catch(SQLException sEx) {
				System.out.println("TemplateDatabaseManager.addTemplateAttributes() : " + sEx);
			}
		}
	}
	
	//removes selected attributes that are already existing in the template
	public ArrayList<String> removeDuplicate(int id, ArrayList<String> attributes) {
		ArrayList<String> attributeList = new ArrayList<String>(); //to store the returning ArrayList
		ArrayList<String> tableRows = new ArrayList<String>(); //store the data from TEMPLATE_ATTRIB table
		String query = "SELECT * FROM TEMPLATE_ATTRIB WHERE TEMPLATE_ID = "  + id;
		
		try {			
			statement = connection.createStatement();
			rowCount = statement.executeQuery(query);
			while(rowCount.next()) {
				int row = rowCount.getInt(2);
				String tableRow = Integer.toString(row);
				tableRows.add(tableRow);
				System.out.println("TemplateDatabaseManager.removeDuplicate() added " + tableRow);
			}
		} catch(SQLException sEx) {
			System.out.println("TemplateDatabaseManager.removeDuplicate() : " + sEx);
		}
		
		//combines attribute list and tableRow list without duplicate
		//values are stored in attributeList list
		for(String attribute : attributes) {
			if (!tableRows.contains(attribute)) {
				attributeList.add(attribute);
				System.out.println("TemplateDatabaseManager.removeDuplicate() added " + attribute + " and has no duplicate");
			}
		}
		
		return attributeList;
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
