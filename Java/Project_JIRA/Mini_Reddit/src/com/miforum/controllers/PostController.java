package com.miforum.controllers;

import java.io.IOException;
import java.io.PrintWriter;

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

public class PostController extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		final String ADD_POST = "add_post";
		
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("activeAccount");
		
		String functionality = request.getParameter("functionality");
		String id = request.getParameter("post_id");
		String title = request.getParameter("post_title");
		String body = request.getParameter("post_body");
		String username = account.getUsername();
		
		Post post = null;
		PostServices services = null;
		PostDatabase database = null;
		
		if(functionality.equals(ADD_POST)) {
			post = new Post(title, body, username);
			database = new PostDatabase();
			services = new PostServices(post, database);
			
			services.addPost();
		}
		
		out.close();
		
	}
}














