package com.dib.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sgsturl")
public class ITStateGSTServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw=null;
		String pname=null,company=null,ptype=null;
		float cost=0.0f;
		float sgst=0.0f;
		ServletContext sc1=null,sc2=null;
		RequestDispatcher rd=null;
		
		pw=response.getWriter();
		response.setContentType("text/html");
		pname=request.getParameter("pname");
		ptype=request.getParameter("ptype");
		company=request.getParameter("company");
		cost=Float.parseFloat(request.getParameter("cost"));
		
		if(ptype.equalsIgnoreCase("product"))
		{
			sgst=cost*0.12f;
		}
		else if(ptype.equalsIgnoreCase("service"))
		{
			sgst=cost*0.1f;
		}
		else if(ptype.equalsIgnoreCase("startup"))
		{
			sgst=cost*0.03f;
		}
		
		pw.println("<h1 style='color:blue;text-align:center'>GST Info</h1>");
		pw.println("<br> Project Name :"+pname);
		pw.println("<br> Project Company :"+company);
		pw.println("<br> Project Type :"+ptype);
		pw.println("<br> Project Cost :"+cost);
		pw.println("<br> Project State GST :"+sgst);
		
		sc1=getServletContext();
		sc2=sc1.getContext("/CentralGSTApp");
		
		rd=sc2.getRequestDispatcher("/cgsturl");
		rd.include(request, response);
		
		pw.println("<br><a href='input.html'>Home</a>");
		
		pw.close();
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
