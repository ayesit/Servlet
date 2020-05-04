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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	@Resource(name="DsJndi")
	private DataSource ds;
	private static final long serialVersionUID = 1L;
	private static final String QUERY="INSERT INTO COOKIE_PERSON_INFO VALUES(PID_SEQ.NEXTVAL,?,?,?,?,?)";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float income=0.0f,tax=0.0f;
		String pname=null,fname=null,gender=null;
		Connection con=null;
		HttpSession ses=null;
		PreparedStatement ps=null;
		int count=0;

		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		ses=request.getSession(false);

		income=Float.parseFloat(request.getParameter("income"));
		tax=Float.parseFloat(request.getParameter("tax"));

		pname=(String) ses.getAttribute("name");
		fname=(String) ses.getAttribute("fname");
		gender=(String) ses.getAttribute("gender");


		try {
			con=ds.getConnection();
			ps=con.prepareStatement(QUERY);

			ps.setString(1, pname);
			ps.setString(2, fname);
			ps.setString(3, gender);
			ps.setFloat(4, income);
			ps.setFloat(5, tax);

			count=ps.executeUpdate();

			if(count==0)
				pw.println("<h1 style='color:red'>Failed</h1>");
			else {
				pw.println("<h1 style='color:green'>Success</h1>");
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			}catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null) {
					con.close();
				}
			}catch (SQLException se) {
				se.printStackTrace();
			}
		}

		pw.println("<br><h3> form1/req1 data :: "+pname+" "+fname+" "+gender+"</h3>");
		pw.println("<br><h3> form2/req2 data :: "+income+" "+tax+"</h3>");
		pw.println("Session ID before Invalidate: "+ses.getId());

		//	Invalidate The Session
		ses.invalidate();
		pw.println("Session ID after Invalidate : "+ses.getId());
		pw.println("<br><a href='input.html'>Home</a>");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
