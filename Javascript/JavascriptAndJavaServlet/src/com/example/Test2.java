package com.example;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class Test2 extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		out.println("Hi " + name + "(" + age + ") This is text from JAVA via POST method");
	}
}
