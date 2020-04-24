package com.dib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dib.bo.EmployeeBO;

public class EmployeeDaoImpl implements EmployeeDAO 
{
  private static final String QUERY="INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?)";
  
	private Connection getPooledJdbcConnection() throws Exception
	{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		ic=new InitialContext();
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		con=ds.getConnection();
		return con;
	}
	
	@Override
	public int insert(EmployeeBO bo) throws Exception 
	{
		Connection con=null;
		PreparedStatement ps=null;
		con=getPooledJdbcConnection();
		ps=con.prepareStatement(QUERY);
		int count=0;
		
		ps.setString(1, bo.getEname());
		ps.setString(2, bo.getEadd());
		ps.setDate(3, bo.getDoj());
		ps.setFloat(4, bo.getBasicSalary());
		ps.setFloat(5, bo.getGrossSalary());
		ps.setFloat(6, bo.getNetSalary());
		
		count=ps.executeUpdate();
		
		ps.close();
		con.close();
		
		return count;
	}
}
