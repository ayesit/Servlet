package com.dib.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/firsturl")
public class FIrstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter pw=null;
	String name=null,fname=null,gender=null;
	Cookie cookie1=null,cookie2=null,cookie3=null;
	
	pw=response.getWriter();
	response.setContentType("text/html");
	
	name=request.getParameter("pname");
	fname=request.getParameter("pfname");
	gender=request.getParameter("gender");
	
	cookie1=new Cookie("pname",name);
	cookie2=new Cookie("pfname",fname);
	cookie3=new Cookie("gender",gender);
	
	response.addCookie(cookie1);
	response.addCookie(cookie2);
	response.addCookie(cookie3);
	
	System.out.println(name);
	
	pw.println("<h1 style='color:blue;text-align:center'>Provide Income Details</h1>");
	pw.println("<form action='secondurl' method='POST'>");
	pw.println("<table align='center'>");
	pw.println("<tr><td> Income of this year</td><td><input type='text' name='income'></td></tr>");
	pw.println("<tr><td> Tax </td><td><input type='text' name='tax'></td></tr>");
	pw.println("<tr><td><input type='submit' value='submit'></td><td><input type='reset' value='cancel'></td></tr>");
	pw.println("</table></form>");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
