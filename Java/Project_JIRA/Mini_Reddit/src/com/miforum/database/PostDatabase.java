package com.miforum.database;

import java.sql.SQLException;

import com.miforum.components.Post;
import com.miforum.components.Account;
import com.miforum.components.Component;

public class PostDatabase extends Database{
	
	private Post post;
	
	private static final String COUNT_TABLE_ROWS = "SELECT * FROM POST ORDER BY ID DESC";
	private static final String INSERT = "INSERT INTO POST VALUES(?,?,?,?,?)";

	@Override
	public void insert(Component component) {
		
		post = (Post) component;
		
		String title = post.getTitle();
		String body = post.getBody();
		String username = post.getAccount();
		String date = "date";
		
		int id = generateId(COUNT_TABLE_ROWS);
		
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, title);
			preparedStatement.setString(3, body);
			preparedStatement.setString(4, username);
			preparedStatement.setString(5, date);
			preparedStatement(preparedStatement);
		} catch (SQLException sEx) {
			System.out.println("AccountDatabase.insert() : " + sEx);
		}
	}


	@Override
	public void delete(Component component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Component oldComponent, Component newComponent) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String select(Component component, int numberOfRows) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String selectOne(Component component) {
		// TODO Auto-generated method stub
		return null;
	}

}
