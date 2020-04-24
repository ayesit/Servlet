package com.dib.bo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter	
public class EmployeeBO 
{
	private String ename;
	private String eadd;
	private Date doj;
	private Float basicSalary;
	private Float grossSalary;
	private Float netSalary;

}
