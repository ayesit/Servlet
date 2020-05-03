package com.dib.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.dib.servlet.SearchServlet;

public class MyInitializer implements ServletContainerInitializer {

	
	
	public MyInitializer() {
		System.out.println("MyInitializer.MyInitializer() No-arg C");
	}

	@Override
	public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
		System.out.println("MyInitializer.onStartup()");
		SearchServlet servlet=null;
		ServletRegistration.Dynamic dyna=null;

		servlet=new SearchServlet();
		dyna=sc.addServlet("search", servlet);
		dyna.addMapping("/searchurl");
		dyna.setLoadOnStartup(1);
	}
}
