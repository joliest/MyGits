package com.tracker.Listener;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.ServletContextListener;
import com.tracker.DatabaseHelper.*;

public class TrackerContext implements ServletContextListener{
	
	Connection databaseConnection;
	
	@Override
	public void contextDestroyed(ServletContextEvent e) {
		try {
			databaseConnection.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent e) {
		ServletContext servletContext = e.getServletContext();
		
		String driverName = servletContext.getInitParameter("DriverClass");
		String connectionUrl = servletContext.getInitParameter("ConnectionURL");
		
		DatabaseHelper helper = new DatabaseHelper(driverName, connectionUrl);
		databaseConnection = helper.getConnection();
		
		servletContext.setAttribute("dbConnection", databaseConnection);
	}

}
