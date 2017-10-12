package com.project1.userandrole.controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import com.project1.db.DatabaseFactory;

public class Administration extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		//get Role List
		ArrayList roleList = DatabaseFactory.getRoleList(req);
		String roleListReady = "";
		for(int i = 0; i < roleList.size(); i++) {
			String role =  roleList.get(i).toString();
			roleListReady += "<option>" + role + "</option>";
		}
		
		/*
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println(roleListReady);
		*/
		
		req.setAttribute("test", "<b>hellow world</p>");
		
		RequestDispatcher view = req.getRequestDispatcher("/web/admin/Admin.jsp");
		view.forward(req, res);
		
	}

}
