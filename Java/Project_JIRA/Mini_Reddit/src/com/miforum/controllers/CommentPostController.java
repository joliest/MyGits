package com.miforum.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miforum.components.*;
import com.miforum.database.*;
import com.miforum.services.*;
import com.miforum.viewresolver.CommentView;

public class CommentPostController extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		final String ADD_COMMENT = "add_comment";
		final String COMMENT = "comment";
		final String SHOW_POST_COMMENTS = "show_post_comments";
		//final String USERNAME = "username";
		
		String functionality = request.getParameter("functionality");
		HttpSession session = request.getSession(false);
		
		Account account;
		Post post;
		
		synchronized(session) {
			account = (Account) session.getAttribute("activeAccount");
			post = (Post) session.getAttribute("post");
		}
		
		if(functionality.equals(ADD_COMMENT)) {
			
			String comment = request.getParameter(COMMENT);

			Comment newComment = new Comment(post, account, comment);
			CommentDatabase database = new CommentDatabase();
			CommentServices services = new CommentServices(newComment, database);
			services.add();
		} 
		
		if(functionality.equals(SHOW_POST_COMMENTS)) {
			CommentDatabase database = new CommentDatabase();
			Comment comment = new Comment(post, account);
			CommentServices services = new CommentServices(comment, database);
			
			ArrayList<Comment> comments = services.getCommentsByPostId(2);
			
			String output = "";
			
			for(int i = 0; i < comments.size(); i++) {
				Comment comm = comments.get(i);
				CommentView view = new CommentView(comm);
				
				output += view + "\n";
			}
			
			out.println(output);
		}
		
		out.close();
	}
}