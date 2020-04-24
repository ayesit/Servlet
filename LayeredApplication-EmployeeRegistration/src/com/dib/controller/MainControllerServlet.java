package com.dib.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dib.dto.EmployeeDTO;
import com.dib.service.EmployeeServiceImpl;
import com.dib.vo.EmployeeVO;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet 
{
	@Override
	public void init() throws ServletException 
	{
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=null,addrs=null,doj=null,basicSalary=null;
		PrintWriter ps=null;
		EmployeeVO vo=null;
		EmployeeDTO dto=null;
		resp.setContentType("text/html");
		
		vo=new EmployeeVO();
		vo.setEname(req.getParameter("ename"));
		vo.setEadd(req.getParameter("eadd"));
		vo.setDoj(req.getParameter("doj"));
		vo.setBasicSalary(req.getParameter("basicSalary"));
		
		ps=resp.getWriter();
		
		dto=new EmployeeDTO();
		
		dto.setEname(vo.getEname());
		dto.setEadd(vo.getEadd());
		dto.setBasicSalary(Float.parseFloat(vo.getBasicSalary()));
		dto.setDoj(java.sql.Date.valueOf(vo.getDoj()));
		
		try
		{
			String result=null;
			EmployeeServiceImpl service=new EmployeeServiceImpl();
			result=service.registerEmployee(dto);
			ps.println("<h1 style='color:red;text-align:center'>Result :: "+result+"</h1>");
		 }//try
		 catch(Exception e) {
			 ps.println("<h1>Internal Problem ---- Try Again</h1>");
//			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }
		//add hyperlink
		 ps.println("<br><br> <a href='employee_registration.html'>home</a>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
