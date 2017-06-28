package com.abeliot.framework.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class BaseEntity implements Serializable {


	private static final long serialVersionUID = -8532724423599134981L;

	private static Map<String, TableMap> dbTableMaps = new HashMap<String, TableMap>();
	
	public TableMap tableMap;
	
	public BaseEntity(Class<?> clazz) {
		// TODO Auto-generated constructor stub
		tableMap = dbTableMaps.get(clazz.getName());

	}
	
	public static TableMap addTableMap(String tableName, Class<?> clazz) {
		// TODO Auto-generated constructor stub
		TableMap tableMap = dbTableMaps.get(clazz.getName());
		
		if(tableMap == null){
			tableMap = new TableMap(tableName, clazz);
			dbTableMaps.put(clazz.getName(), tableMap);
		}

		return tableMap;
	}
	
	public boolean setTableMap(String tableName, Class<?> clazz) {
		// TODO Auto-generated constructor stub
		TableMap tableMap = dbTableMaps.get(clazz.getName());
		
		if(tableMap == null){
			tableMap = new TableMap(tableName, clazz);
			dbTableMaps.put(clazz.getName(), tableMap);
			return true;
		}else{
			return false;
		}
	}
		
	public static TableMap getDbTableMap(Class<?> clazz){
		return dbTableMaps.get(clazz.getName());
	}
	
	public static DbTable getDbTable(Class<?> clazz){
		return dbTableMaps.get(clazz.getName()).dbTable;
	}

	public String getTableName(){
		return tableMap.dbTable.name;
	}
	
	public DbTable getDbTable(){
		return tableMap.dbTable;
	}
	
	public Set<String> getDbFields(){
		return tableMap.getDbFields();
	}
	
	public void setFieldMap(String dbFieldName,String javaFieldName){
		tableMap.setFieldMap(dbFieldName, javaFieldName);
	}
	
	public FieldMap getFieldMap(String dbFieldName){
		return tableMap.getFieldMap(dbFieldName);
	}
	
}
