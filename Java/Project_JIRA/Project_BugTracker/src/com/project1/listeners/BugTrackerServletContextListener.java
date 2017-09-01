package com.project1.listeners;
import javax.servlet.*;
import java.sql.*;
import com.project1.db.*;

public class BugTrackerServletContextListener implements ServletContextListener{

	DBConnector dbConnector;
	
	public void contextDestroyed(ServletContextEvent event) {
		dbConnector.closeConnection();		
	}

	public void contextInitialized(ServletContextEvent event) {
		ServletContext dbDriverName = event.getServletContext();
		String driverName = dbDriverName.getInitParameter("driverName");
		
		ServletContext dbConnectionName = event.getServletContext();
		String connectionName = dbConnectionName.getInitParameter("connectionName");
		
		ServletContext dbUsername = event.getServletContext();
		String username = dbUsername.getInitParameter("dbUsername");
		
		ServletContext dbPassword = event.getServletContext();
		String password = dbPassword.getInitParameter("dbPassword");
		
		dbConnector = new DBConnector(driverName, connectionName);
		dbConnector.setUsername(username);
		dbConnector.setPassword(password);
		
		Connection dbConnection = dbConnector.connect();
		
		event.getServletContext().setAttribute("databaseConnection", dbConnection);
	}

}
