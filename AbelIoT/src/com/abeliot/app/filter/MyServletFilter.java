package com.abeliot.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter(urlPatterns={"/*"},
		initParams={
			@WebInitParam(name="type", value="myfilter")
		})
public class MyServletFilter implements Filter {



	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("%%%%%%%%%%%%%MyServletFilter : destroy : %%%%%%%%%%%%%%%");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filter) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("************MyServletFilter : doFilter : " + req.getContentType());
		
		HttpServletRequest request = (HttpServletRequest)req;
		String reqURI = request.getRequestURI();
		System.out.println("contextPath = " + req.getServletContext().getContextPath());
		System.out.println("reqURI = " + reqURI);
		
//		if(reqURI.equals(request.getContextPath()+"/login")){
//			filter.doFilter(req, resp);
//			return;
//		}
		
		
		String loginId = request.getParameter("loginId");
		String passwd = request.getParameter("passwd");

		System.out.println("param.loginId = " + loginId);
		System.out.println("param.passwd = " + passwd);
		
//		HttpSession session = request.getSession();
//		
//		Account user = (Account)session.getAttribute("loginUser");
//		
//		if(user == null){
//			System.out.println("session.loginUser is null");
//			//servletContext.getRealPath()得到的是本地的绝对路径不是URL
////			req.getRequestDispatcher(request.getServletContext().getRealPath("/login.jsp")).forward(req, resp);
//			req.getRequestDispatcher("/login.jsp").forward(req, resp);
//		}else{
//			System.out.println("session.loginUser exist");	
//			System.out.println("session.login_name = " + user.login_name);
//			System.out.println("session.login_passwd = " + user.login_passwd);
//			
//			filter.doFilter(req, resp);
//		}
	
		filter.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		// TODO Auto-generated method stub

		String type = fc.getInitParameter("type");
		
		System.out.println("###########MyServletFilter : init : type = " + type 
				+ ", filtername " + fc.getFilterName());
	}

}
