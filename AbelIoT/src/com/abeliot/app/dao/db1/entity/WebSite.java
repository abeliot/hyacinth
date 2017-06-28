package com.abeliot.app.dao.db1.entity;

import com.abeliot.framework.base.BaseEntity;
import com.abeliot.framework.base.TableMap;

public class WebSite extends BaseEntity {

	private static final long serialVersionUID = 3452284762449599424L;

	public int id;
	public String name;
	public String url;
	public String logo;
	public String remarks;
	
	static {
		TableMap tableMap = addTableMap("website", WebSite.class);
		tableMap.setFieldMap("id", "id");
		tableMap.setFieldMap("name", "name");
		tableMap.setFieldMap("url", "url");
		tableMap.setFieldMap("logo", "logo");
		tableMap.setFieldMap("remarks", "remarks");
	}
	
	public WebSite() {
		// TODO Auto-generated constructor stub
		super(WebSite.class);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
