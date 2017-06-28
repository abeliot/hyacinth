package com.abeliot.app.dao.db1.entity;

import com.abeliot.framework.base.BaseEntity;
import com.abeliot.framework.base.ByteUtils;
import com.abeliot.framework.base.TableMap;

public class Info extends BaseEntity{


	/**
	 * 
	 */
	private static final long serialVersionUID = 2193901900142405322L;

//	public static String namespace = "com.app.db1.InfoMapper";
	
	public int id;
	public int age;
	public String name;
	public byte[] sign_data = new byte[16];
	
	
	static{
		TableMap tableMap = addTableMap("info", Info.class);
		tableMap.setFieldMap("id", "id");
		tableMap.setFieldMap("age", "age");
		tableMap.setFieldMap("name", "name");
		tableMap.setFieldMap("sign_data", "sign_data");
	}
	
	public Info() {
		// TODO Auto-generated constructor stub
		super(Info.class);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getSign_data() {
		return sign_data;
	}

	public void setSign_data(byte[] sign_data) {
		this.sign_data = sign_data;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("id : " + id + "\n");
		sb.append("name : " + name + "\n");
		sb.append("age : " + age + "\n");
		sb.append("sign_data : \n" + ByteUtils.toHexString(sign_data) + "\n");
		return sb.toString();
	}
	
}
