package com.dib.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		RequestDispatcher rd=null, rd1=null;
		
		rd=request.getRequestDispatcher("/HeaderServlet");
		rd.include(request, response);
		
		PrintWriter pw=null;
		pw=response.getWriter();
		response.setContentType("text/html");
		
		System.out.println("ErrorServlet.doGet()");
		
		pw.println("Internal Error");
		pw.println("<br><a href='input.html'>Home</a>");
		
		rd1=request.getRequestDispatcher("/footer.html");
		rd1.include(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
