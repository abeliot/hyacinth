package com.abeliot.framework.base;

import java.lang.reflect.Field;

public class FieldMap {
	
	TableMap tableMap;
	public String dbFieldName;
	Field javaField;
	
	public FieldMap() {
		// TODO Auto-generated constructor stub
	}
	
	public FieldMap(TableMap tableMap, String dbFieldName) {
		// TODO Auto-generated constructor stub
		this.tableMap = tableMap;
		this.dbFieldName = dbFieldName;
	}
		
	public Object getValue(Object obj){
		
		Object value = null;
		
		try {
			value = javaField.get(obj);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
	}
	
	public void setValue(Object obj, Object value){
		
		try {
			javaField.set(obj, value);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
