package com.abeliot.framework.base;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.multiaction.MethodNameResolver;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


public class BaseController extends MultiActionController{

	
	@Autowired
	protected javax.servlet.ServletContext servletContext;
//	
//	@Autowired
//	protected HttpSession session;
//
//	@Autowired  
//	protected HttpServletRequest request; 
	
	
	@Resource(name = "parameterMethodNameResolver")
	public void setActionMethodNameResolver(MethodNameResolver methodNameResolver) {
		// TODO Auto-generated method stub
		super.setMethodNameResolver(methodNameResolver);

	}

}