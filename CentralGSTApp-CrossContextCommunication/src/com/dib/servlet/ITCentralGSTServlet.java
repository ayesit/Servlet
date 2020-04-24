package com.dib.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cgsturl")
public class ITCentralGSTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw=null;
		float cost=0.0f;
		float cgst=0.0f;
		String type=null;
		response.setContentType("text/html");
		
		cost=Float.parseFloat(request.getParameter("cost"));
		pw=response.getWriter();
		type=request.getParameter("ptype");
		
		if(type.equalsIgnoreCase("product"))
		{
			cgst=cost*0.18f;
		}
		else if(type.equalsIgnoreCase("service"))
		{
			cgst=cost*0.15f;
		}
		else if(type.equalsIgnoreCase("startup"))
		{
			cgst=cost*0.10f;
		}
		
		pw.println("<br> Project Central GST :"+cgst);
	
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
