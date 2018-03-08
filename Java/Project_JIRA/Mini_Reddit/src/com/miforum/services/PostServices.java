package com.miforum.services;

import java.util.ArrayList;

import com.miforum.components.Post;
import com.miforum.database.PostDatabase;

public class PostServices {
	
	private Post post;
	private PostDatabase database;
	
	public PostServices(Post post, PostDatabase database) {
		this.post = post;
		this.database = database;
	}
	
	public PostServices(PostDatabase database) {
		this.database = database;
	}
	
	public void addPost() {
		if(post != null) {
			database.insert(post);
		} else {
			throw new NullPointerException("Post object is not found");
		}
	}
	
	public ArrayList<Post> getPostsByUsername(String username, int numberOfRows) {
		ArrayList<Post> list = database.getPostsByUsername(username, numberOfRows);
		return list;
	}

	
	
}
