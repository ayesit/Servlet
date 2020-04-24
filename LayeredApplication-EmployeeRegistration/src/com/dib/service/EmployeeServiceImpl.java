package com.dib.service;

import com.dib.bo.EmployeeBO;
import com.dib.dao.EmployeeDAO;
import com.dib.dao.EmployeeDaoImpl;
import com.dib.dto.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService 
{	
	private EmployeeDAO dao;
	public EmployeeServiceImpl()
	{
		dao=new EmployeeDaoImpl();
	}

	@Override
	public String registerEmployee(EmployeeDTO dto) throws Exception 
	{	
		float grossSalary=0.0f;
		float netSalary=0.0f;
		EmployeeBO bo=null;
		int count=0;
		
		grossSalary=dto.getBasicSalary()+dto.getBasicSalary()*0.4f;
		netSalary=grossSalary-(grossSalary*0.2f);
		
		bo=new EmployeeBO();
		bo.setEname(dto.getEname());
		bo.setEadd(dto.getEadd());
		bo.setDoj(dto.getDoj());
		bo.setBasicSalary(dto.getBasicSalary());
		bo.setGrossSalary(grossSalary);
		bo.setNetSalary(netSalary);
		
		count=dao.insert(bo);
		
		if(count==0)
			return "Registration Failed";
		else
			return "Registration Successful";
	}
}
