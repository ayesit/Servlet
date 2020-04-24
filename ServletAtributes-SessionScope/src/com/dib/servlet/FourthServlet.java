package com.dib.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/FourthServlet")
public class FourthServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=null;
		HttpSession ses=null;
		
		pw=response.getWriter();
		response.setContentType("text/html");
		ses=request.getSession();
		
		pw.println("[Fourth Servlet] Request Attribute 1 value :"+request.getAttribute("attr1"));
		pw.println("[Fourth Servlet] Session Attribute 2 value :"+ses.getAttribute("attr2"));
	
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
