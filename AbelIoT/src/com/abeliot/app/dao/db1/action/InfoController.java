package com.abeliot.app.dao.db1.action;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abeliot.app.dao.db1.entity.Info;
import com.abeliot.app.dao.db1.service.InfoService;
import com.abeliot.framework.base.BaseController;
import com.abeliot.framework.base.DbTable;
import com.abeliot.framework.base.PageList;
import com.abeliot.framework.base.SqlStatement;


@Scope("prototype")
@Controller
@RequestMapping("/info.do")
public class InfoController extends BaseController {
	
	@Resource(name = "db1.infoBiz")
	private InfoService infoBiz;
	
	private static int pageSize = 10;
	private static int pageIndex = 1;
	
	public ModelAndView show(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("info");
		
		String idval = request.getParameter("id");
		
		if(idval==null){
			System.out.println("info param id is null ");		
		}else{
			int id = Integer.parseInt(idval);
			
			Info info = infoBiz.dao.queryById(id);
			mav.addObject("id", info.id);
			mav.addObject("age", info.age);
			mav.addObject("name", info.name);
	 
		}
		
		
		return mav;
	}
	
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("infoList");
		
		SqlStatement sql = new SqlStatement();
//		DbTable accountTable = account.tableMap.dbTable;
//		DbTable infoTable = BaseEntity.getDbTable(Info.class);
		DbTable infoTable = DbTable.get("info");
//		System.out.println(infoTable);
		sql.addDbTable(infoTable);

//		List<?> infoList = dao.queryList(sql);
//		mav.addObject("infoList", infoList);
		String pageSizeParam = request.getParameter("pageSize");
		String pageIndexParam = request.getParameter("pageIndex");

		
		if(pageSizeParam!=null && pageSizeParam!=""){
			pageSize = Integer.valueOf(pageSizeParam);
		}
		if(pageIndexParam!=null && pageIndexParam!=""){
			pageIndex = Integer.valueOf(pageIndexParam);
		}
		
//		PageList<Info> pageList = dao.queryPageList(sql, pageSize, index);
		PageList<?> pageList = infoBiz.dao.selectPageList(sql, pageSize, pageIndex);
		
		System.out.println(pageList);
		
		mav.addObject("pageList", pageList);
		
		
		return mav;
	}
	
	public ModelAndView del(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));

//		System.out.println("del " + id);
		infoBiz.dao.deleteById(id);
		
		return list(request, response);
	}
	
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("info");
		
		
		Info info = new Info();
		
		
		info.id = Integer.parseInt(request.getParameter("id"));
		info.age = Integer.parseInt(request.getParameter("age"));
		info.name = request.getParameter("name");
		
		infoBiz.dao.insertObj(info);
		
		mav.addObject("id", info.id);
		mav.addObject("age", info.age);
		mav.addObject("name", info.name);
		
		return mav;
	}

}
