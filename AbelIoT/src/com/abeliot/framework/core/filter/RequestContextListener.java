package com.abeliot.framework.core.filter;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


//@WebListener
public class RequestContextListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent requestEvent) {
		// TODO Auto-generated method stub
		System.out.println("^^^^^^^^^^^^^^RequestContextListener^^^^^^^^^^^^ : requestDestroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent requestEvent) {
		// TODO Auto-generated method stub
		System.out.println("$$$$$$$$$$$$$$RequestContextListener$$$$$$$$$$$$ : requestInitialized");
		
		if (!(requestEvent.getServletRequest() instanceof HttpServletRequest)) {
			throw new IllegalArgumentException("");
			}
			HttpServletRequest request = (HttpServletRequest) requestEvent.getServletRequest();
	
			ServletRequestAttributes attributes = new ServletRequestAttributes(request);
//			request.setAttribute("", attributes);
			LocaleContextHolder.setLocale(request.getLocale());
			RequestContextHolder.setRequestAttributes(attributes);
	}

}
