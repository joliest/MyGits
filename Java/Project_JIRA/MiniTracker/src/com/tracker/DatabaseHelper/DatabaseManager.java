package com.tracker.DatabaseHelper;

import java.sql.*;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.tracker.Module;

public abstract class DatabaseManager {
	
	protected PreparedStatement preparedStatement;
	protected Statement statement;
	protected ResultSet rowCount;
	
	protected Connection connection;
	protected HttpServletRequest request;
	protected Module module;
	
	
	public DatabaseManager(HttpServletRequest request) {
		ServletContext servletConfig = request.getServletContext();
		connection = (Connection) servletConfig.getAttribute("dbConnection");
	}
	
	public DatabaseManager(Module module) {
		this.module = module;
		this.request = module.getHttpRequest();
		
		ServletContext servletConfig = request.getServletContext();
		connection = (Connection) servletConfig.getAttribute("dbConnection");
	}
	
	public abstract void add();	
	public abstract void update();
	public abstract String remove(int id);
	public abstract void view();
	public abstract HashMap<Integer, String> listGroups();
	public abstract HashMap<Integer, String> getMembersByGroupId(int groupId);
	
	
	
	protected abstract int generateId();
}
