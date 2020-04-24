package com.dib.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw=null;
		String when=null, why=null;
		String pname=null, fname=null, status=null;
		
		pw=response.getWriter();
		
		pname=request.getParameter("pname");
		fname=request.getParameter("fname");
		status=request.getParameter("ms");
		
		when=request.getParameter("f2t1");
		why=request.getParameter("f2t2");
		
		pw.println("<h1 style=\"color:blue;text-align:center\">Result Page</h1>");
		pw.println("<br>Form 1 Data :"+pname+" "+fname+" "+status);
		pw.println("<br>Form 2 Data :"+when+" "+why);
		
		pw.println("<br><a href='input.html'>Home</a>");
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
