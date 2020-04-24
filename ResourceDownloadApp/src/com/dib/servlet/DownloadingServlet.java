package com.dib.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

@WebServlet("/downloadurl")
public class DownloadingServlet extends HttpServlet 

{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		File file=null;
		String filename=null;
		ServletContext sc=null;
		String type=null;
		InputStream is=null;
		OutputStream os=null;
		
		filename=req.getParameter("filename");
		file=new File("E:/store/"+filename);
		sc=getServletContext();
		type=sc.getMimeType("E:/store/"+filename);
		is=new FileInputStream(file);
		os=resp.getOutputStream();
		resp.setHeader("Content-Disposition", "attachment:filename="+filename);
		
		IOUtils.copy(is,os);
		
		is.close();
		os.close();
		
		resp.setContentLengthLong(file.length());
		resp.setContentType(type!=null?type:"application/octet-stream");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		doGet(req, resp);
	}

}
