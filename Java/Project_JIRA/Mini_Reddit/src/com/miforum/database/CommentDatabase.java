package com.miforum.database;

import java.sql.SQLException;

import com.miforum.components.*;


public class CommentDatabase extends Database{
	
	private Comment comment;
	
	private final String MAX_TABLE_ROW = "SELECT MAX(ID) FROM COMMENTS";
	private final String INSERT = "INSERT INTO COMMENTS VALUES(?,?,?,?,?,?,?)";
	
	@Override
	public void insert(Component component) {

		comment = (Comment) component;
		
		Post post = comment.getPost();
		Account account = comment.getAccount();
		
		String comm = comment.getComment();
		String date = "";
		String postId = post.getId();
		
		int upVotes = comment.getUpVotes();
		int downVotes = comment.getDownVotes();
		int postIdNum = Integer.parseInt(postId);
		
		int id = generateId(MAX_TABLE_ROW);
		
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, comm);
			preparedStatement.setString(3, date);
			preparedStatement.setString(4, account.getUsername());
			preparedStatement.setInt(5, postIdNum);
			preparedStatement.setInt(6, 0);
			preparedStatement.setInt(7, 0);
			preparedStatement(preparedStatement);
		} catch (SQLException sEx) {
			System.out.println("CommentDatabase.insert() : " + sEx);
		}
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

	@Override
	public void delete(Component component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Component oldComponent, Component newComponent) {
		// TODO Auto-generated method stub
		
	}

}
