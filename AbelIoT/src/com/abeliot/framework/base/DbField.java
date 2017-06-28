package com.abeliot.framework.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class DbField {
	
	DbTable table;
	String name;
	Object value;
	
	public DbField() {
		// TODO Auto-generated constructor stub
	}
	
	public DbField(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public DbField(DbTable table, String name) {
		// TODO Auto-generated constructor stub
		this.table = table;
		this.name = name;
	}

	
	public Object getValue(){
		return value;
	}
	
	public void setValue(Object value){
		this.value = value;
	}
	
	private String toSqlString(Object obj){
		
		if(obj instanceof String){
			return ("'" + obj + "'");
		}else if(obj instanceof byte[]){
			return "x'" + ByteUtils.toHexString((byte[])obj) + "'";	
		}else if(obj instanceof Date){
			return ("'" + DateUtils.format((Date)obj) + "'");
		}else if(obj instanceof DbField){
			DbField field = (DbField)obj;
			return (field.table.name + "." + field.name);
		}else{
			return (obj.toString());
		}
	}
	
	public String getValueString(){
		return toSqlString(value);
	}
	
	//@SuppressWarnings("unchecked")
	public String[] getValueSqlStrings(){

		ArrayList<String> strList = new ArrayList<String>();
		
		if((value instanceof Collection)){
			Collection<Object> valueList = (Collection<Object>)value;
			for(Object obj : valueList){
				strList.add(toSqlString(obj));
			}
		}else if(value instanceof byte[]){
			strList.add( "x'" + ByteUtils.toHexString((byte[])value) + "'");	
		}else if((value.getClass().isArray())){
			Object[] valueArray = (Object[])value;
			for(Object obj : valueArray){
				strList.add(toSqlString(obj));
			}
		}else{
			strList.add(toSqlString(value));
		}
		
		return strList.toArray(new String[0]);
	}
}
