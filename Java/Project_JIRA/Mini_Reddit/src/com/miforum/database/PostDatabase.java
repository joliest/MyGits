package com.miforum.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.miforum.components.Post;
import com.miforum.components.Component;

public class PostDatabase extends Database{
	
	private Post post;
	
	private static final String COUNT_TABLE_ROWS = "SELECT MAX(ID) FROM POST";
	private static final String INSERT = "INSERT INTO POST VALUES(?,?,?,?,?,?,?)";
	private static final String SELECT_POSTS_BY_USERNAME = "SELECT * FROM POST WHERE USERNAME=? ORDER BY ID DESC";

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
			preparedStatement.setInt(6, 0);
			preparedStatement.setInt(7, 0);
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


	public ArrayList<Post> getPostsByUsername(String username, int numberOfRows) {
		
		ArrayList<Post> list = new ArrayList<Post>();
		ResultSet resultSet;
		
		int rowLimit = 0;
		
		try {
			preparedStatement = connection.prepareStatement(SELECT_POSTS_BY_USERNAME);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int id = resultSet.getInt(1);
				String title = resultSet.getString(2);
				String body = resultSet.getString(3);
				String user = resultSet.getString(4);
				String date = resultSet.getString(5);
				int upVotes = resultSet.getInt(6);
				int downVotes = resultSet.getInt(7);
				
				Post post = new Post(title, body, user);
				post.setId(id);
				post.setDate(date);
				post.setUpVotes(upVotes);
				post.setDownVotes(downVotes);
				
				list.add(post);
				
				rowLimit++;
				
				if(rowLimit == numberOfRows) {
					break;
				}
			}
		} catch (SQLException sEx) {
			System.out.println("AccountDatabase.getPostsByUsername() : " + sEx);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			}			
		}
		
		return list;
	}

}
