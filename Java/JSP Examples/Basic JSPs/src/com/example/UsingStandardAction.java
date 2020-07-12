package com.example;

import java.io.IOException;
import java.io.PrintWriter;


//http://localhost:9888/Basic_JSPs/standard-action.do
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.packages.Person;

public class UsingStandardAction extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Person person = new Person();
		person.setName("Arlene");
		
		request.setAttribute("person", person);
		
		RequestDispatcher view = request.getRequestDispatcher("/jsp-examples/standard-action.jsp");
		view.forward(request, response);
	}

}
