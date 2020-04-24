package com.dib.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession ses=null;
		RequestDispatcher rd=null;
		ServletContext sc=null;
		
		request.setAttribute("attr1","val1");
		rd=request.getRequestDispatcher("/SecondServlet");
		ses=request.getSession();
		ses.setAttribute("attr2", "val2");
		sc=getServletContext();
		sc.setAttribute("attr3", "val3");
		rd.forward(request, response);
		
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
