package com.dib.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SearchServlet extends HttpServlet 
{
	public SearchServlet() {
		System.out.println("SearchServlet.SearchServlet() No-arg C");
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("SearchServlet.doGet()");
		
		String query=null,engine=null;

		response.setContentType("text/html");
		query=request.getParameter("query");
		engine=request.getParameter("engine");

		if(engine.equalsIgnoreCase("google")) 
		{
			response.sendRedirect("https://www.google.com/search?q="+query);
		}
		else if(engine.equalsIgnoreCase("bing")) 
		{
			response.sendRedirect("https://www.bing.com/search?q="+query);
		}
		else if(engine.equalsIgnoreCase("yahoo")) 
		{
			response.sendRedirect("https://www.yahoo.com/search?p="+query);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		System.out.println("SearchServlet.doPost()");
		doGet(request, response);
	}

}
