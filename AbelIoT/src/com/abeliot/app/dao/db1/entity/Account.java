package com.abeliot.app.dao.db1.entity;

import java.util.Date;

import com.abeliot.framework.base.BaseEntity;
import com.abeliot.framework.base.DateUtils;
import com.abeliot.framework.base.FieldMap;
import com.abeliot.framework.base.TableMap;

public class Account extends BaseEntity {

	private static final long serialVersionUID = 2877025379225776225L;
	
	public Integer id;
	public String login_name;
	public String login_passwd;
	public String display_name;
	public Date register_date;
	public Date update_date;
	public Integer account_status;
	
	public static FieldMap idField;
	public static FieldMap login_nameField;
	public static FieldMap login_passwdField;
	public static FieldMap display_nameField;
	public static FieldMap register_dateField;
	public static FieldMap update_dateField;
	public static FieldMap account_statusField;
	
	static {
		TableMap tableMap = addTableMap("account", Account.class);
		idField = tableMap.setFieldMap("id", "id");
		login_nameField = tableMap.setFieldMap("login_name", "login_name");
		login_passwdField = tableMap.setFieldMap("login_passwd", "login_passwd");
		display_nameField = tableMap.setFieldMap("display_name", "display_name");
		register_dateField = tableMap.setFieldMap("register_date", "register_date");
		update_dateField = tableMap.setFieldMap("update_date", "update_date");
		account_statusField = tableMap.setFieldMap("account_status", "account_status");
	}
	
	public Account() {
		// TODO Auto-generated constructor stub
		super(Account.class);
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getLogin_passwd() {
		return login_passwd;
	}
	public void setLogin_passwd(String login_passwd) {
		this.login_passwd = login_passwd;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public String getRegister_date() {
		return DateUtils.format(register_date);
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	public Integer getAccount_status() {
		return account_status;
	}
	public void setAccount_status(Integer account_status) {
		this.account_status = account_status;
	}
	public String getUpdate_date() {
		return DateUtils.format(update_date);
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("account.id = " + this.id + "\n");
		sb.append("account.login_name = " + this.login_name + "\n");
		sb.append("account.login_passwd = " + this.login_passwd + "\n");
		sb.append("account.display_name = " + this.display_name + "\n");
		sb.append("account.account_status = " + this.account_status + "\n");
		sb.append("account.register_date = " + DateUtils.format(this.register_date) + "\n");
		sb.append("account.update_date = " + DateUtils.format(this.update_date) + "\n");
		return sb.toString();
	}
}
