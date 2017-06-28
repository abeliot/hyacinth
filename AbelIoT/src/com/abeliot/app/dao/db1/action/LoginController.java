package com.abeliot.app.dao.db1.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abeliot.app.dao.db1.AccountDao;
import com.abeliot.app.dao.db1.entity.Account;
import com.abeliot.framework.base.BaseController;

@Scope("prototype")
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {


	@Resource(name = "db1.accountDao")
	AccountDao accountDao;
	
//	@RequestMapping(params = "method=checkIn")
//	public String checkIn(HttpServletRequest request, ModelMap modelMap) {
	public ModelAndView checkIn(HttpServletRequest request, HttpServletResponse response) {
		
//		ModelAndView mav = new ModelAndView("loginstatus");
//		ModelAndView mav = new ModelAndView();
		
		String loginId = request.getParameter("loginId");
		String passwd = request.getParameter("passwd");

		System.out.println("param.loginId = " + loginId);
		System.out.println("param.passwd = " + passwd);
		
		HttpSession session = request.getSession();
		Account account = null;
		
		if(loginId == null){
			System.out.println("param.loginId is null, doesn't select db");				
		}else{
			account = accountDao.selectByLoginName(loginId);
			if(account == null){
				System.out.println("select Account by loginId is null");
			}
		}
	
		if(account!=null){
			System.out.println("account.id = " + account.id);
			System.out.println("account.login_name = " + account.login_name);
			System.out.println("account.login_passwd = " + account.login_passwd);
			System.out.println("account.display_name = " + account.display_name);
			System.out.println("account.account_status = " + account.account_status);
			System.out.println("account.register_date = " + account.register_date.toString());
			session.setAttribute("loginUser", account);
		}else{
			System.out.println("account.login_name = " + "not found");
			System.out.println("account.login_passwd = " + "is empty");
		}
		
//		mav.addObject("account", account);
//		modelMap.put("account", account);

		System.out.println("don't return any modeandview");
//		request.setAttribute("account", account);
		try {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			PrintWriter out = response.getWriter();
//			out.println("<html><head>");
//			out.println("<title>login result</title>");
//			out.println("</head><body>");
//			out.println("<h1>login finished : </h1>");
//			out.println("account.loginId = " + account.loginId + "<br>");
//			out.println("account.passwd = " + account.passwd + "<br>");
//			out.println("</body>");
//			out.println("</html>");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		return "login";
//		return "loginstatus";
		return null;
	}

	
//	@Override
//	protected ModelAndView handleRequestInternal(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		// TODO Auto-generated method stub
//		return super.handleRequestInternal(request, response);
//	}
}
