package com.abeliot.app.dao.db1.action;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abeliot.app.dao.db1.AccountDao;
import com.abeliot.app.dao.db1.entity.Account;
import com.abeliot.framework.base.BaseController;
import com.abeliot.framework.base.BaseEntity;
import com.abeliot.framework.base.DbTable;
import com.abeliot.framework.base.PageList;
import com.abeliot.framework.base.SqlStatement;


@Scope("prototype")
@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {

	
	@Resource(name = "db1.accountDao")
	AccountDao accountDao;
	
	public ModelAndView show(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("account/list");
		
		SqlStatement sql = new SqlStatement();
		DbTable accountTable = BaseEntity.getDbTableMap(Account.class).dbTable;
		sql.addDbTable(accountTable);
//		List<?> objList = accountDao.selectList(sql); 
		int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		PageList<Account> pageList = accountDao.queryPageList(sql, 10, pageIndex);
//		for(Object obj : objList){
//			System.out.print(obj);
//		}
		
		mav.addObject("pageList", pageList);
		
		return mav;
	}
	
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("account");
		
		String loginId = request.getParameter("loginId");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");

		System.out.println("param.loginId = " + loginId);
		System.out.println("param.name = " + name);
		System.out.println("param.passwd = " + passwd);

		Account account = new Account();
		
		account.login_name = loginId;
		account.display_name = name;
		account.login_passwd = passwd;
		
		accountDao.insertObj(account);
		
		mav.addObject("account", account);

		//System.out.println("don't return any modeandview");
		
		return mav;
	}
}
