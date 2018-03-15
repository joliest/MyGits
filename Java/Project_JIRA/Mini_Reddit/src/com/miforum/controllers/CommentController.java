package com.miforum.controllers;

import java.io.IOException;

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

public class CommentController extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(false);
		Account activeAccount = (Account) session.getAttribute("activeAccount");
		
		if(activeAccount == null) { 
			response.sendRedirect("/Mini_Reddit/home");	
		} else {
			
			String postId = request.getParameter("postId"); 
			int id = Integer.parseInt(postId);
			
			PostDatabase postDatabase = new PostDatabase();
			PostServices postServices = new PostServices(postDatabase);
			Post post = postServices.getPostById(id);
			
			synchronized(session) {
				session.setAttribute("post", post);
			}
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/comment.jsp");
			view.forward(request, response);
		}
		
	}
}
