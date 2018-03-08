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

			StringWriter sw = new StringWriter();
			
			for(int i = 0; i < posts.size(); i++) {
				
				Post post = posts.get(i);
				
				String upVotes = Integer.toString(post.getUpVotes());
				String downVotes = Integer.toString(post.getDownVotes());
				
				sw.append("<tr> <td colspan=\"2\">");
				sw.append(post.getTitle());
				sw.append("<br />");
				sw.append("by: " + post.getAccount());
				sw.append("</td> </tr>");
				
				sw.append("<tr> <td colspan=\"2\">");
				sw.append(post.getBody());
				sw.append("</td> </tr>");
				
				sw.append("<tr>");
				sw.append("<td>" + upVotes + "</td>");
				sw.append("<td>" + downVotes + "</td>");
				sw.append("</tr>");
			}
			
			System.out.println(sw.toString());
			out.println(sw.toString());
			
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
