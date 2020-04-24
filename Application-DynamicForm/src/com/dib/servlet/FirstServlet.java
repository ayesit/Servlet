package com.dib.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw=null;
		String pname=null, fname=null, status=null;
		
		pname=request.getParameter("pname");
		fname=request.getParameter("fname");
		status=request.getParameter("ms");
		pw=response.getWriter();
		response.setContentType("text/html");
		
		if(status.equalsIgnoreCase("single"))
		{
			pw.println("<h1 style='color:blue;text-align:center'>Provide Bachelor Life Related Data</h1>");
			pw.println("<form action='secondurl' method='Post'>");
			pw.println("<table align='center'>");
			pw.println("<tr><td>When Do you want</td> <td><input type='text' name='f2t1'</td></tr>");
			pw.println("<tr><td>Why Do you want</td> <td><input type='text' name='f2t2'</td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit'value='submit'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
		else if(status.equalsIgnoreCase("married"))
		{
			pw.println("<h1 style='color:blue;text-align:center'>Marriage Life Related Data</h1>");
			pw.println("<form action='secondurl' method='Post'>");
			pw.println("<table align='center'>");
			pw.println("<tr><td>How many kids?</td> <td><input type='text' name='f2t1'</td></tr>");
			pw.println("<tr><td>Husband Name?</td> <td><input type='text' name='f2t2'</td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit'value='submit'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
		
		pw.close();
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
