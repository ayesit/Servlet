package com.dib.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionDurationAnalyzerListener implements HttpSessionListener {

	private long start=0,end=0;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("SessionDurationAnalyzerListener.sessionCreated()");
		ServletContext sc=null;
		start=System.currentTimeMillis();
		sc=se.getSession().getServletContext();
		sc.log("Session ID "+se.getSession().getId()+" Started on"+new Date());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("SessionDurationAnalyzerListener.sessionDestroyed()");
		ServletContext sc=null;
		end=System.currentTimeMillis();
		sc=se.getSession().getServletContext();
		sc.log("Session ID "+se.getSession().getId()+" Ended on"+new Date());
		sc.log("Session ID "+se.getSession().getId()+" Duration is "+(end-start)+" Millis");
		System.out.println("Session ID "+se.getSession().getId()+" Duration is "+(end-start)+" Millis");
	}

}
