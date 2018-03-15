package com.miforum.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.miforum.components.*;
import com.miforum.services.PostServices;


public class CommentDatabase extends Database{
	
	private Comment comment;
	
	private final String MAX_TABLE_ROW = "SELECT MAX(ID) FROM COMMENTS";
	private final String INSERT = "INSERT INTO COMMENTS VALUES(?,?,?,?,?,?,?)";
	private final String SELECT_COMMENTS_BY_POST_ID = "SELECT * FROM COMMENTS WHERE POSTID=";
	private final String SELECT_COMMENT_BY_ID = "SELECT * FROM COMMENTS WHERE ID="; 
	
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

	public ArrayList<Comment> getCommentsByPostId(int rowNumberToBegin, int rowNumberToEnd, int postId) {
		ArrayList<Comment> list = new ArrayList<Comment>();
		ResultSet resultSet;
				
		try {
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
														ResultSet.CONCUR_UPDATABLE);
			
			
			resultSet = statement.executeQuery(SELECT_COMMENTS_BY_POST_ID + postId);
			resultSet.relative(rowNumberToBegin);
			
			while(resultSet.getRow() <= rowNumberToEnd) {
				
				int id = resultSet.getInt(1);		
				String commentText = resultSet.getString(2);
				String date = resultSet.getString(3);
				String commentOwner = resultSet.getString(4);
				//int postIdSQL = resultSet.getInt(5);
				int upVotes = resultSet.getInt(6);
				int downVotes = resultSet.getInt(7);
				
				Account account = new Account(commentOwner);
				
				PostServices postServices = new PostServices(new PostDatabase());
				Post post = postServices.getPostById(postId);
				
				Comment newComment = new Comment(post, account, commentText);
				newComment.setId(id);
				newComment.setDate(date);
				newComment.setUpVotes(upVotes);
				newComment.setDownVotes(downVotes);
				
				list.add(newComment);
				
				if(!resultSet.next()) {
					break;
				}
				
			}
		} catch (SQLException sEx) {
			System.out.println("CommentDatabase.getRecentPosts() : " + sEx);
		} finally {
			try {
				if (statement != null) {
					statement.close();
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

	public Comment getCommentById(int id) {
		
		//returns null if id is valid
		
		Comment comment = null;
		
		try {
			preparedStatement = connection.prepareStatement(SELECT_COMMENT_BY_ID + id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
						
				String commentText = resultSet.getString(2);
				String date = resultSet.getString(3);
				String commentOwner = resultSet.getString(4);
				int postId = resultSet.getInt(5);
				int upVotes = resultSet.getInt(6);
				int downVotes = resultSet.getInt(7);
				
				Account account = new Account(commentOwner);
				
				PostServices postServices = new PostServices(new PostDatabase());
				Post post = postServices.getPostById(postId);
				
				comment = new Comment(post, account, commentText);
				comment.setId(id);
				comment.setDate(date);
				comment.setUpVotes(upVotes);
				comment.setDownVotes(downVotes);
				
				return comment;
				
			}
		} catch (SQLException sEx) {
			System.out.println("CommentDatabase.getCommentById() : " + sEx);
		}
		
		return comment;
		
	}
}
