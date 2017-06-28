package com.abeliot.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(
//	urlPatterns={"/account", "/accountServlet"},
//	initParams={
//			@WebInitParam(name="type", value="checking")
//	})
public class AccountServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7213826068312984629L;
	
	String type = null;

	public AccountServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		type = config.getInitParameter("type");
		
		System.out.println("account servlet init type = " + type);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		try {
			
			PrintWriter out = resp.getWriter();
			
			String txValue = req.getParameter("tx");
			System.out.println("account servlet doget : tx value = " + txValue);
			
			out.println("<html><head>");
			out.println("<title>MyServlet</title>");
			out.println("</head><body>");
			out.println("<h1>My First Servlet</h1>");
			out.println("</body>");
			out.println("</html>");
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			
		}
	}
}
