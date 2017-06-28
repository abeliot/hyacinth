package com.abeliot.framework.base;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DbTable{

	public String name;
	public Map<String, DbField> fieldMaps;
	
	private static Map<String, DbTable> dbTableMaps = new HashMap<String, DbTable>();
	

	public DbTable(String tableName) {
		// TODO Auto-generated constructor stub
		this.name = tableName;
		fieldMaps = new HashMap<>();
	}
	
	public DbTable(String tableName, int fieldCount) {
		// TODO Auto-generated constructor stub
		this.name = tableName;
		fieldMaps = new HashMap<>(fieldCount);
	}

	public static void set(String tableName, DbTable dbTable){
		dbTableMaps.put(tableName, dbTable);
	}
	
	public static DbTable get(String tableName){
		return dbTableMaps.get(tableName);
	}
	
	public static DbTable add(String tableName){
		
		DbTable dbTable = get(tableName);
		
		if(dbTable == null){
			dbTable = new DbTable(tableName);
			set(tableName, dbTable);
		}
		
		return dbTable;
	}
	
	public static DbTable add(String tableName, int fieldCount){
		
		DbTable dbTable = get(tableName);
//		System.out.println("DbTableMaps : addDbTable "+tableName);
		if(dbTable == null){
			dbTable = new DbTable(tableName, fieldCount);
			set(tableName, dbTable);
		}
		
		return dbTable;
	}
	
	public static DbTable add(String tableName, Collection<String> fieldSet){
		
		DbTable dbTable = get(tableName);
		
		if(dbTable == null){
		
			dbTable = new DbTable(tableName, fieldSet.size());
			
			set(tableName, dbTable);
			
			for(String fieldName : fieldSet ){
				dbTable.setField(fieldName);
			}
		}
		
		return dbTable;
	}
	
	public static DbTable add(String tableName, String ... fieldNames){
		
		DbTable dbTable = get(tableName);
		
		if(dbTable == null){
			
			dbTable = new DbTable(tableName, fieldNames.length);
			
			set(tableName, dbTable);
		
			for(String fieldName : fieldNames){
				dbTable.setField(fieldName);
			}
		}
		
		return dbTable;
	}
		
	public Set<String> getFields(){
		return fieldMaps.keySet();
	}
	
	public DbField addField(String fieldName){
		DbField dbField = fieldMaps.get(fieldName);
		if(dbField == null){
			dbField = new DbField(this, fieldName);
			fieldMaps.put(fieldName, dbField);
		}
		return dbField;
	}
	
	public DbField setField(String fieldName){
		DbField dbField = new DbField(this, fieldName);
		fieldMaps.put(fieldName, dbField);
		return dbField;
	}
	
	public void setField(DbField field){
		field.table = this;
		fieldMaps.put(field.name, field);
	}
	
	public DbField getField(String fieldName){
		return fieldMaps.get(fieldName);
	}
	
	public DbField newField(String fieldName){
		DbField dbField = getField(fieldName);
		DbField newField = null;
		if(dbField != null){
			newField = new DbField(fieldName);
			newField.table = dbField.table;
		}
		return newField;
	}
	
	public DbField newField(String fieldName, Object value){
		DbField dbField = getField(fieldName);
		DbField newField = null;
		if(dbField != null){
			newField = new DbField(fieldName);
			newField.table = dbField.table;
			newField.value = value;
		}
		return newField;
	}

}
