package com.example.web;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class MyTester extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String name = req.getParameter("username");
		
		out.println("Hello " + name);
		
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
