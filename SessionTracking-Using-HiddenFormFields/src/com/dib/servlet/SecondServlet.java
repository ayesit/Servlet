package com.dib.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="DsJndi")
	private DataSource ds;
	private static final String QUERY="INSERT INTO PERSON_INFO VALUES (PID_SEQ.NEXTVAL,?,?,?,?,?)";
 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw=null;
		String when=null, why=null;
		String pname=null, fname=null, status=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
		
		pw=response.getWriter();
		
		
		pname=request.getParameter("hname");
		fname=request.getParameter("hfname");
		status=request.getParameter("hms");
		
		when=request.getParameter("f2t1");
		why=request.getParameter("f2t2");
		
		
		try {
			
			con=ds.getConnection();
			ps=con.prepareStatement(QUERY);
			
			ps.setString(1, pname);
			ps.setString(2, fname);
			ps.setString(3, status);
			ps.setString(4, when);
			ps.setString(5, why);
			
			result=ps.executeUpdate();
			
			if(result==0)
				pw.println("Error : Failed");
			else
				pw.println("Successfully Registered");
			
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null)
				{
					ps.close();
				}
			}catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
				{
					con.close();
				}
			}catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		
		pw.println("<h1 style=\"color:blue;text-align:center\">Result Page</h1>");
		pw.println("<br>Form 1 Data :"+pname+" "+fname+" "+status);
		pw.println("<br>Form 2 Data :"+when+" "+why);
		
		pw.println("<br><a href='input.html'>Home</a>");
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
