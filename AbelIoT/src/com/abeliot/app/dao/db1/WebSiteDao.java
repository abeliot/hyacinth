package com.abeliot.app.dao.db1;

import org.springframework.stereotype.Repository;

import com.abeliot.app.dao.db1.entity.WebSite;


@Repository("db1.webSiteDao")
public class WebSiteDao extends Db1SimpleDao<WebSite> {

	public WebSiteDao() {
		// TODO Auto-generated constructor stub
		super(WebSite.class);
	}
	
	
}
