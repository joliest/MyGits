package com.miforum.services;

import com.miforum.components.Post;
import com.miforum.database.PostDatabase;

public class PostServices {
	
	private Post post;
	private PostDatabase database;
	
	public PostServices(Post post, PostDatabase database) {
		this.post = post;
		this.database = database;
	}
	
	public void addPost() {
		database.insert(post);
	}
	
	
}
