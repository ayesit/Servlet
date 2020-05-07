package com.dib.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebApplicationMonitoringListener implements ServletContextListener {

	private long start=0,end=0;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("WebApplicationMonitoringListener.contextInitialized()");
		ServletContext sc=null;
		sc=sce.getServletContext();
		start=System.currentTimeMillis();
		sc.log(sc.getContextPath()+" ID deployed/restarted/reloaded at "+new Date());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("WebApplicationMonitoringListener.contextDestroyed()");
		ServletContext sc=null;
		sc=sce.getServletContext();
		end=System.currentTimeMillis();
		sc.log(sc.getContextPath()+" ID undeployed/stopped/reloaded at "+new Date());
		sc.log(sc.getContextPath()+"Duration is "+(end-start)+" Millis");
	}


}
