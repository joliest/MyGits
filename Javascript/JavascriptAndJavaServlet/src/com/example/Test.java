package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Test extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.print("This is from JAVA Servlet");
	}
}
