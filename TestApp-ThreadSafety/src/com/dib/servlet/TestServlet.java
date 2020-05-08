package com.dib.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet implements SingleThreadModel {
	private static final long serialVersionUID = 1L;

	public TestServlet() {
		System.out.println("TestServlet.TestServlet() No-Arg Constructor");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("TestServlet.doGet() HashCode"+this.hashCode());
		PrintWriter pw=null;
		pw=res.getWriter();
		pw.println(new Date()+" HashCode"+this.hashCode());
		
		try {
			Thread.sleep(20000);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		pw.close();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	
		System.out.println("TestServlet.doPost()");
		doGet(req, res);
	}

}
