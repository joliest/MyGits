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

import com.miforum.components.Account;
import com.miforum.components.Post;
import com.miforum.database.PostDatabase;
import com.miforum.services.PostServices;
import com.miforum.viewresolver.PostListView;
import com.miforum.viewresolver.PostView;

public class PostController extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		final String ADD_POST = "add_post";
		final String DISPLAY_RECENT_POSTS= "display_recent_posts";
		final String DISPLAY_PREVIOUS_POSTS = "display_previous_posts";
		
		HttpSession session = request.getSession();
		Account account = null;
		synchronized(session) {
			account = (Account) session.getAttribute("activeAccount");
		}
		
		String functionality = request.getParameter("functionality");
		String id = request.getParameter("post_id");
		
		Post post = null;
		PostServices services = null;
		PostDatabase database = new PostDatabase();
		PostListView view = null;
		
		if(functionality.equals(ADD_POST)) {			
			
			String title = request.getParameter("post_title");
			String body = request.getParameter("post_body");
			String username = account.getUsername();
			
			post = new Post(title, body, username);
			services = new PostServices(post, database);
			services.addPost();
		} 
		
		if(functionality.equals(DISPLAY_RECENT_POSTS)) {
			PostServices displayServices;
			
			synchronized(session) {
				displayServices = (PostServices) session.getAttribute("displayServices");
			}
			
			if(displayServices == null) {
				services = new PostServices(database);
				synchronized(session) {
					session.setAttribute("displayServices", services);
				}
			} else {
				services = displayServices;
				services.setDatabase(database);
			}
			
			ArrayList<Post> posts = services.getNextPost();

			String output = "";
			
			for(int i = 0; i < posts.size(); i++) {
				post = (Post) posts.get(i);
				view = new PostListView(post);
				output += view;
			}
			
			out.println(output);
		}
		
		if(functionality.equals(DISPLAY_PREVIOUS_POSTS)) {
			PostServices displayServices;
			
			synchronized(session) {
				displayServices = (PostServices) session.getAttribute("displayServices");
			}
			
			if(displayServices == null) {
				services = new PostServices(database);
				synchronized(session) {
					session.setAttribute("displayServices", services);
				}
			} else {
				services = displayServices;
				services.setDatabase(database);
			}
			
			ArrayList<Post> posts = services.getPreviousPost();

			String output = "";
			
			for(int i = 0; i < posts.size(); i++) {
				post = (Post) posts.get(i);
				view = new PostListView(post);
				output += view;
			}
			
			out.println(output);
		}
		
		out.close();
		
	}
}














