package com.dib.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter	
public class EmployeeDTO 
{
	private String ename;
	private String eadd;
	private Date doj;
	private Float basicSalary;
	
}
