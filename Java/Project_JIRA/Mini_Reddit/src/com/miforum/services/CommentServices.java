package com.miforum.services;

import java.util.ArrayList;

import com.miforum.components.Comment;
import com.miforum.components.Component;
import com.miforum.components.Post;
import com.miforum.database.CommentDatabase;
import com.miforum.database.PostDatabase;

public class CommentServices implements Service{
	
	private Comment comment;
	private CommentDatabase database;
	
	private int currentPageNumber;
	private int existingRows;
	private int numberOfRowsNeeded;
	private int numberOfPages;
	private int rowNumberToBegin;
	private int rowNumberToEnd;
	
	private int postId;
	
	public CommentServices(Comment comment, CommentDatabase database) {
		this.comment = comment;
		this.database = database;
		
		String id = comment.getPost().getId();		
		postId = Integer.parseInt(id);
		
		init();
	}
	
	public CommentServices(CommentDatabase database) {
		this.database = database;
		init();
	}
	
	public CommentServices() {
		this.database = new CommentDatabase();
		init();
	}
	
	private void init() {
		//Load defaults:
		currentPageNumber = 0;
		existingRows = new PostDatabase().countRows();
		numberOfRowsNeeded = 3;
		numberOfPages = existingRows / numberOfRowsNeeded;
		rowNumberToBegin = 1;
		
	}
	
	@Override
	public void add() {
		if(comment != null) {
			database.insert(comment);
		} else {
			throw new NullPointerException("Comment object is not found");
		}
	}

	@Override
	public void modify(int id, String changes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Component component) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public ArrayList<Comment> getCommentsByPostId(int numberOfRows) {
		
		ArrayList<Comment> comments;
		if(rowNumberToEnd > existingRows) {
			currentPageNumber--;
		}
		currentPageNumber++;
		rowNumberToEnd = numberOfRowsNeeded * currentPageNumber; 
		rowNumberToBegin = (rowNumberToEnd - numberOfRowsNeeded) + 1;	
		
		comments = database.getCommentsByPostId(rowNumberToBegin, rowNumberToEnd, postId); 
		 
		return comments;
	}
	
	public Comment getCommentById(int id) {
		CommentDatabase db = new CommentDatabase();
		Comment theComment = (Comment) db.getCommentById(id);
		return theComment;
	}

	public int upVote(Comment comment) {

		CommentDatabase database = createConnection();
		
		int currentUpvotes = comment.getUpVotes();
		int upVoted = currentUpvotes + 1;
		
		comment.setUpVotes(upVoted);
		
		database.upVote(comment);
		
		return upVoted;
	}

	public CommentDatabase createConnection() {
		return new CommentDatabase();
	}

	public int downVote(Comment comment) {
		CommentDatabase database = createConnection();
		
		int currentDownvotes = comment.getDownVotes();
		int downVoted = currentDownvotes + 1;
		
		comment.setDownVotes(downVoted);
		database.downVote(comment);
		
		return downVoted;
	}

}
