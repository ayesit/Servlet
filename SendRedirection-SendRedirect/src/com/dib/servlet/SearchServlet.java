package com.dib.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
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
		doGet(request, response);
	}

}
