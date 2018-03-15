package com.miforum.services;

import com.miforum.components.Comment;
import com.miforum.components.Component;
import com.miforum.database.CommentDatabase;

public class CommentServices implements Service{
	
	private Comment comment;
	private CommentDatabase database;
	
	public CommentServices(Comment comment, CommentDatabase database) {
		this.comment = comment;
		this.database = database;
	}
	
	public CommentServices(CommentDatabase database) {
		this.database = database;
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

}
