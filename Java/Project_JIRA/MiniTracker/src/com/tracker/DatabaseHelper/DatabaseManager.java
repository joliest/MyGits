package com.tracker.DatabaseHelper;

import java.sql.*;

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
	
	public DatabaseManager(Module module) {
		this.module = module;
		this.request = module.getHttpRequest();
		
		ServletContext servletConfig = request.getServletContext();
		connection = (Connection) servletConfig.getAttribute("dbConnection");
	}
	
	public abstract void add();	
	public abstract void update();
	public abstract void remove();
	public abstract void view();
	
	
	
	protected abstract int generateId();
}
