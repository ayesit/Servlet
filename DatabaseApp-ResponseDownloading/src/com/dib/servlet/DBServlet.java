package com.dib.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DBServlet extends HttpServlet
{
	private static final String QUERY="SELECT EMAIL_ADDRESS,FIRST_NAME,LAST_NAME FROM EMPLOYEES WHERE ID=?";
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		int eid=0;
		PrintWriter pw=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
		pw=res.getWriter();
		res.setContentType("application/msword");
		res.addHeader("Content-Disposition", "attachment;filename=result.doc");
		eid=Integer.parseInt(req.getParameter("eid"));
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cropy");
		ps=con.prepareStatement(QUERY);
		ps.setInt(1,eid);
		rs=ps.executeQuery();
		if(rs.next())
		{
			pw.println("Email :"+rs.getString(1)+"<br/>");
			pw.println("First Name :"+rs.getString(2)+"<br/>");
			pw.println("Last Name :"+rs.getString(3)+"<br/>");
			pw.println("<br><a href='input.html'>Home</a>");
		}
		else
		{
			pw.println("Database Error");
			pw.println("<br><a href='input.html'>Home</a>");
		}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf)
		{
			cnf.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
			if(rs!=null)
			{
				rs.close();
			}
			}
			catch(SQLException se)
		    {
			se.printStackTrace();
		    }
			try
			{
			if(ps!=null)
			{
				ps.close();
			}
			}
			catch(SQLException se)
		    {
			se.printStackTrace();
		    }
			try
			{
			if(con!=null)
			{
				con.close();
			}
			}
			catch(SQLException se)
		    {  
		 	se.printStackTrace();
		    }
			try
			{
			if(pw!=null)
			{
				pw.close();
			}
			}
			catch(Exception e)
		    {  
		 	e.printStackTrace();
		    }
		}
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		doGet(req,res);
	}
}