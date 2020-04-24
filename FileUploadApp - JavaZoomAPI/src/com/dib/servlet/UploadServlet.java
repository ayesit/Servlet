package com.dib.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;

@WebServlet("/uploadurl")
public class UploadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	PrintWriter pw=null;
	MultipartFormDataRequest nreq=null;
	UploadBean bean=null;
	Vector vector=null;
	UploadParameters param=null;
	pw=response.getWriter();
	response.setContentType("text/html");
	
	
	try
	{
		nreq=new MultipartFormDataRequest(request);
		bean=new UploadBean();
		
		bean.setFolderstore("e:/store");
		bean.setOverwrite(false);
		bean.setMaxfiles(10);
//		bean.setFilesizelimit(20*1024);
		bean.setBlacklist("*.exe,*.zip,*.pdf");
		bean.store(nreq);
		
		vector=bean.getHistory();
		
		for(int i=1; i<vector.size(); ++i )
		{
			param=(UploadParameters)vector.elementAt(i);
			pw.println("<b> file name : "+param.getFilename());
			pw.println("<b> file size: "+param.getFilesize());
			pw.println("<b> file type: "+param.getContenttype());
			pw.println("<b> file info: "+param.getStoreinfo());
		}
		
		
	}
	catch (Exception e) 
	{
		pw.println("Problem");
		e.getMessage();
		System.out.println(e);
	}
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
