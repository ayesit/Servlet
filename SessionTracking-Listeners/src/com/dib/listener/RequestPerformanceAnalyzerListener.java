package com.dib.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestPerformanceAnalyzerListener implements ServletRequestListener {

	private long start=0,end=0;
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		start=System.currentTimeMillis();
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		ServletContext sc=null;
		HttpServletRequest req=null;
		
		end=System.currentTimeMillis();
		sc=sre.getServletContext();
		req=(HttpServletRequest) sre.getServletRequest();
		sc.log(req.getRequestURI()+"has taken "+(end-start)+" ms time to process the request");
		System.out.println(req.getRequestURI()+"has taken "+(end-start)+" ms time to process the request");
	}
}
