package com.miforum.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.miforum.components.Post;
import com.miforum.components.Component;

public class PostDatabase extends Database{
	
	private Post post;
	
	private final String MAX_TABLE_ROW = "SELECT MAX(ID) FROM POST";
	private final String COUNT_TABLE_ROW = "SELECT COUNT(USERNAME) FROM POST";
	private final String INSERT = "INSERT INTO POST VALUES(?,?,?,?,?,?,?)";
	private final String SELECT_POSTS_BY_USERNAME = "SELECT * FROM POST WHERE USERNAME=? ORDER BY ID DESC";
	//private static final String SELECT_POSTS_BY_ROW_RANGE = "SELECT * FROM (SELECT P.*, ROWNUM R FROM POST P) WHERE R BETWEEN ? AND ?";
	private final String SELECT_POSTS_ORDER_BY_ID_DESC = "SELECT * FROM POST ORDER BY ID DESC";
	private final String SELECT_POSTS_BY_ID = "SELECT * FROM POST WHERE ID=";
	private final String UPDATE_UPVOTE_BY_ID = "UPDATE POST SET UPVOTES=? WHERE ID=?";
	private final String UPDATE_DOWNVOTE_BY_ID = "UPDATE POST SET DOWNVOTES=? WHERE ID=?";
	//private final String SELECT_POST_UPVOTES = "SELECT UPVOTE FROM POST WHERE ID=?";

	@Override
	public void insert(Component component) {
		
		post = (Post) component;
		
		String title = post.getTitle();
		String body = post.getBody();
		String username = post.getAccount();
		String date = "date";
		
		int id = generateId(MAX_TABLE_ROW);
		
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
	
	public ArrayList<Post> getRecentPosts(int rowNumberToStart, int rowNumberToEnd) {
		ArrayList<Post> list = new ArrayList<Post>();
		ResultSet resultSet;
				
		try {
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
														ResultSet.CONCUR_UPDATABLE);
			resultSet = statement.executeQuery(SELECT_POSTS_ORDER_BY_ID_DESC);
			resultSet.relative(rowNumberToStart);
			
			while(resultSet.getRow() <= rowNumberToEnd) {
				
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
				
				if(!resultSet.next()) {
					break;
				}
				
			}
		} catch (SQLException sEx) {
			System.out.println("PostDatabase.getRecentPosts() : " + sEx);
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


	public Post getPostById(int id) {
		
		Post post = null;
		
		try {
			preparedStatement = connection.prepareStatement(SELECT_POSTS_BY_ID + id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				
				int postId = resultSet.getInt(1);			
				String title = resultSet.getString(2);
				String body = resultSet.getString(3);
				String user = resultSet.getString(4);
				String date = resultSet.getString(5);
				int upVotes = resultSet.getInt(6);
				int downVotes = resultSet.getInt(7);
				
				post = new Post(title, body, user);
				post.setId(postId);
				post.setDate(date);
				post.setUpVotes(upVotes);
				post.setDownVotes(downVotes);
				
			}
		} catch (SQLException sEx) {
			System.out.println("PostDatabase.getPostById() : " + sEx);
		}  finally {
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
		
		return post;
		
	}
	
	public int countRows() {
		int count = 0;
		
		try {
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(COUNT_TABLE_ROW);
			resultSet.next();
			
			count = resultSet.getInt(1);
			
		} catch (SQLException sEx) {
			System.out.println("PostDatabase.countRows() : " + sEx);
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
		
		return count;
		
	}


	public void upVote(Post p) {
		
		String postId = p.getId(); 
		
		int id = Integer.parseInt(postId);
		int upvotes = p.getUpVotes();
		
		try {
			preparedStatement = connection.prepareStatement(UPDATE_UPVOTE_BY_ID);
			preparedStatement.setInt(1,upvotes);
			preparedStatement.setInt(2, id);
			preparedStatement.executeQuery();			
		} catch(SQLException sEx) {
			System.out.println(sEx);
			System.out.println("PostDatabase.upVote() : " + sEx);
		}  finally {
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
	}
	
	public void downVote(Post p) {
		
		String postId = p.getId();
		
		int id = Integer.parseInt(postId);
		int downvotes = p.getDownVotes();
		
		try {
			preparedStatement = connection.prepareStatement(UPDATE_DOWNVOTE_BY_ID);
			preparedStatement.setInt(1,downvotes);
			preparedStatement.setInt(2, id);
			preparedStatement.executeQuery();			
		} catch(SQLException sEx) {
			System.out.println(sEx);
			System.out.println("PostDatabase.downVote() : " + sEx);
		}  finally {
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
	}

	/*
	public ArrayList<Post> getRecentPosts(int rowNumberToBegin, int rowNumberToEnd) {
		ArrayList<Post> list = new ArrayList<Post>();
		ResultSet resultSet;
		
		try {
			preparedStatement = connection.prepareStatement(SELECT_POSTS_BY_ROW_RANGE);
			preparedStatement.setInt(1, rowNumberToBegin);
			preparedStatement.setInt(2, rowNumberToEnd);
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
			}
		} catch (SQLException sEx) {
			System.out.println("AccountDatabase.getRecentPosts() : " + sEx);
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
	*/
	
}
