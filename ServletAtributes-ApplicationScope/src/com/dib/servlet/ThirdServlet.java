package com.dib.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=null;
		HttpSession ses =null;
		ServletContext sc=null;
		
		pw=response.getWriter();
		response.setContentType("text/html");
		ses= request.getSession();
		sc=getServletContext();
		
		pw.println("[Third Servlet] Request Attribute 1 value :"+request.getAttribute("attr1"));
		pw.println("\n[Third Servlet] Session Attribute 2 value :"+ses.getAttribute("attr2"));
		pw.println("\n[Third Servlet] Application Attribute 3 value :"+sc.getAttribute("attr3"));
		
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
