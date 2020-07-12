package com.miforum.tags;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.miforum.components.Post;
import com.miforum.database.PostDatabase;
import com.miforum.services.PostServices;
import com.miforum.viewresolver.PostView;

public class UserPostsTag extends SimpleTagSupport{
	
	private PostDatabase database;
	private PostServices service;
	
	private ArrayList<Post> posts;
	
	private int numberOfRows = 5;
	private String currentUser = "";
	
	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}
	
	public void setcurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
	
	@Override
	public void doTag() throws JspException {
		
		init();
		
		try {
			JspContext pageContext = getJspContext();
			JspWriter out = pageContext.getOut();
			
			String output = "";

			for(int i = 0; i < posts.size(); i++) {
				
				Post post = posts.get(i);					
				PostView view = new PostView(post);
				output += view;
			}
			
			out.println(output);
			
		} catch(IOException e) {
			System.out.println("UserPostsTag.doTag() : " + e);
		}
	}
	
	private void init() {
		database = new PostDatabase();
		service = new PostServices(database);
		posts = service.getPostsByUsername(currentUser, numberOfRows);
	}
	
}
