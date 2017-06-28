package com.abeliot.framework.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TableMap{

	public DbTable dbTable;
	public Class<?> clazz;
	public Map<String, FieldMap> fieldMaps;
	
	public TableMap(String tableName, Class<?> clazz) {
		// TODO Auto-generated constructor stub
		this.clazz = clazz;
		int fieldCount = clazz.getDeclaredFields().length;
		this.dbTable = DbTable.add(tableName, fieldCount);
		this.fieldMaps = new HashMap<String, FieldMap>(fieldCount);
	}
	
	public Set<String> getDbFields(){
		return fieldMaps.keySet();
	}
		
	public FieldMap setFieldMap(String dbFieldName,String javaFieldName){
		
		FieldMap fieldMap = null;
		
		try {
			
			fieldMap = new FieldMap(this, dbFieldName);
			fieldMaps.put(dbFieldName, fieldMap);
			fieldMap.javaField = clazz.getDeclaredField(javaFieldName);
			
			dbTable.addField(fieldMap.dbFieldName);
			
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fieldMap;
	}
	
	public void setFieldMap(FieldMap fieldMap){
		fieldMaps.put(fieldMap.dbFieldName, fieldMap);
		dbTable.addField(fieldMap.dbFieldName);
	}
	
	public FieldMap getFieldMap(String dbFieldName){
		return fieldMaps.get(dbFieldName);
	}
		
	public Object getObjFieldValue(Object obj, String dbFieldName){
		FieldMap fieldMap = getFieldMap(dbFieldName);
		return fieldMap.getValue(obj);
	}
	
	public void setObjFieldValue(Object obj, String javaFieldName, Object value){
		FieldMap fieldMap = getFieldMap(javaFieldName);
		fieldMap.setValue(obj, value);
		
	}
}
