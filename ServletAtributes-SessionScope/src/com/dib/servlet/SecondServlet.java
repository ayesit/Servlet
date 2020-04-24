package com.dib.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=null;
		RequestDispatcher rd=null;
		HttpSession ses=null;
		pw=response.getWriter();
		response.setContentType("text/html");
		ses=request.getSession();
		
		pw.println("[Second Servlet] Request Attribute 1 value :"+request.getAttribute("attr1"));
		pw.println("[Second Servlet] Session Attribute 2 value :"+ses.getAttribute("attr2"));
		
		rd=request.getRequestDispatcher("/ThirdServlet");
		rd.forward(request, response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
