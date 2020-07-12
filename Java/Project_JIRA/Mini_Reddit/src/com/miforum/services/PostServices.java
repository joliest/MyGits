package com.miforum.services;

import java.util.ArrayList;

import com.miforum.components.Post;
import com.miforum.database.PostDatabase;

public class PostServices {
	
	private Post post;
	private PostDatabase database;
	
	private int currentPageNumber;
	private int numberOfPages;
	private int existingRows;
	private int numberOfRowsNeeded;
	private int rowNumberToBegin;
	private int rowNumberToEnd;	

	private void init() {
		//Load defaults:
		currentPageNumber = 0;
		existingRows = new PostDatabase().countRows();
		numberOfRowsNeeded = 3;
		numberOfPages = existingRows / numberOfRowsNeeded;
		rowNumberToBegin = 1;
	}
	
	public PostServices(Post post, PostDatabase database) {
		this.post = post;
		this.database = database;
		init();
	}	
	
	public PostServices(PostDatabase database) {
		this.database = database;
		init();
	}
	
	public PostServices() {
		this.database = createConnection();
		init();
	}
	
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}
	
	public int getNumberOfRowsNeeded() {
		return numberOfRowsNeeded;
	}

	public void setNumberOfRowsNeeded(int numberOfRowsNeeded) {
		this.numberOfRowsNeeded = numberOfRowsNeeded;
	}

	public void addPost() {
		if(post != null) {
			database.insert(post);
		} else {
			throw new NullPointerException("Post object is not found");
		}
	}
	
	public Post getPostById(int id) {
		
		PostDatabase database = createConnection();
		
		Post thePost = (Post) database.getPostById(id);
		return thePost;
	}
	
	public void setDatabase(PostDatabase database) {
		this.database = database;
	}

	public ArrayList<Post> getPostsByUsername(String username, int numberOfRows) {
		ArrayList<Post> list = database.getPostsByUsername(username, numberOfRows);
		return list;
	}
	
	public ArrayList<Post> getNextPost() {
		ArrayList<Post> posts;
		if(rowNumberToEnd > existingRows) {
			currentPageNumber--;
		}
		currentPageNumber++;
		rowNumberToEnd = numberOfRowsNeeded * currentPageNumber; 
		rowNumberToBegin = (rowNumberToEnd - numberOfRowsNeeded) + 1;	
		
		posts = database.getRecentPosts(rowNumberToBegin, rowNumberToEnd); 
		
		return posts;
	}
	
	public ArrayList<Post> getPreviousPost() {
		ArrayList<Post> posts;
		currentPageNumber = currentPageNumber - 1;
		if(currentPageNumber <= 0) {
			currentPageNumber = 1;
		}
		rowNumberToEnd = numberOfRowsNeeded * currentPageNumber;
		rowNumberToBegin = (rowNumberToEnd - numberOfRowsNeeded) + 1; 
		if(rowNumberToBegin <= 0) {
			rowNumberToBegin = 1;
		}
		
		posts = database.getRecentPosts(rowNumberToBegin, rowNumberToEnd);
		
		return posts;
	}

	public int upVote(Post p) {
		
		PostDatabase database = createConnection();
		
		int currentUpvotes = p.getUpVotes();
		int upVoted = currentUpvotes + 1;
		
		p.setUpVotes(upVoted);
		
		database.upVote(p);
		
		return upVoted;
	}
	
	public PostDatabase createConnection() {
		return new PostDatabase();
	}
	
	public int downVote(Post p) {
		PostDatabase database = createConnection();
		
		int currentDownvotes = p.getDownVotes();
		int downVoted = currentDownvotes + 1;
		
		p.setDownVotes(downVoted);
		
		database.downVote(p);
		
		return downVoted;
	}
}


