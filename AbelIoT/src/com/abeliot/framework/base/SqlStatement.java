package com.abeliot.framework.base;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SqlStatement {

	public static final int	CREATE = 0;
	public static final int	INSERT = 1;
	public static final int	DELETE = 2;
	public static final int	UPDATE = 3;
	public static final int	SELECT = 4;
	public static final int	REPLACE = 5;
	public static final int	DROP = 6;
	
	private static final String[] SQL_OPERATORS = {"CREATE", "INSERT", "DELETE", "UPDATE", "SELECT", "REPLACE","DROP"};
	
	public static final String LogicAnd = "AND";
	public static final String LogicOr = "OR";
	
	public static final String OrderAsc = "ASC";
	public static final String OrderDesc = "DESC";
	
	private class SqlCondition {
		
//		String logic;
		String cond;
		DbField field;
		
//		public SqlCondition() {
//			// TODO Auto-generated constructor stub
//		}
		
		public SqlCondition(DbField field, String cond) {
			// TODO Auto-generated constructor stub
			this.cond = cond;
			this.field = field;
		}
		
		public String toString(boolean withTablePrefix){
			
			String condition = cond.toUpperCase();
			String[] values = field.getValueSqlStrings();
			StringBuffer sb = new StringBuffer();
			
			sb.append(" " + LogicAnd + " ");
			if(withTablePrefix){
				sb.append(field.table.name + "." + field.name);
			}else{
				sb.append(field.name);
			}
			sb.append(" " + condition + " ");
			
			switch(condition){
				case "=" :
				case "<=>" :

				case "<>" :
				case "!=" :

				case ">=" :
				case ">" :
				case "<=" :
				case "<" :
					
				case "IS" :
				case "IS NOT" :

				case "LIKE" :
				case "NOT LIKE" :
					
				case "RLIKE" :
				case "REGEXP" :
					
				case "NOT RLIKE" :
				case "NOT REGEXP" :
					sb.append(values[0]);
					
					break;
				case "IS NULL" :
				case "IS NOT NULL" :
					
					break;
				case "BETWEEN" :
				case "NOT BETWEEN" :
					sb.append(values[0] + " AND " + values[1]);
					
					break;
				case "IN" :
				case "NOT IN" :
					sb.append("(");
					for(String val : values){
						sb.append(val + ",");
					}
					sb.setCharAt(sb.length()-1, ')');
					
					break;
			}
			
			return sb.toString();
		}
	
	}

	private boolean withTablePrefix = false;
	private boolean isPrepared = false;
	
	private List<DbField> fieldList;
	private List<DbTable> tableList = new ArrayList<>(2);
	private List<SqlCondition> conditionList;
	private Map<String,String> orderByMap;
	
	private String sqlOperStr;
	private StringBuffer fieldStrBuf = new StringBuffer();
	private StringBuffer condStrBuf = new StringBuffer();
	private StringBuffer tableStrBuf = new StringBuffer();


	public void addDbTable(DbTable dbTable){
		if(dbTable == null){
			return;
		}
		tableList.add(dbTable);
		if(tableList.size()>1){
			withTablePrefix = true;
		}
	}
	
	public void addField(DbField dbField){
		
		if(dbField == null){
			return;
		}
		
		if(fieldList == null){
			fieldList = new ArrayList<>();
		}
		
		fieldList.add(dbField);
	}
	
	public void addField(DbField dbField, Object value){
		
		if(dbField == null){
			return;
		}
		
		if(fieldList == null){
			fieldList = new ArrayList<>();
		}
		
		dbField.value = value;
		fieldList.add(dbField);
	}
	
	public void addOrderBy(DbField dbField, String order){
		
		if(dbField == null){
			return;
		}
		
		if(orderByMap == null){
			orderByMap = new HashMap<String, String>();
		}
		
		if(withTablePrefix){
			orderByMap.put(dbField.table.name+"."+dbField.name, order);
		}else{
			orderByMap.put(dbField.name, order);
		}
	}
	
	public void addCondition(DbField dbField, String cond){
		
		if(dbField == null){
			return;
		}
		
		if(conditionList == null){
			conditionList = new ArrayList<>();
		}
		
		conditionList.add(new SqlCondition(dbField, cond));
	}
	
	public void addCondition(DbField dbField, String cond, Object value){
		
		if(dbField == null){
			return;
		}
		
		if(conditionList == null){
			conditionList = new ArrayList<>();
		}
		
		dbField.value = value;
		SqlCondition sqlCond = new SqlCondition(dbField, cond);
		conditionList.add(sqlCond);
	}
	
	public boolean prepareSql(int sqlOper){
		
		if(tableList.isEmpty()){
			return false;
		}
		
		if(isPrepared){
			return true;
		}
		
		sqlOperStr = (SQL_OPERATORS[sqlOper]);
		
		switch(sqlOper){
		
			case CREATE :
				
				break;
			case REPLACE :
			case INSERT :
				
				if((fieldList==null) || (fieldList.size() == 0)){
					return false;
				}
				
				int fieldCount = 0;
				DbTable dbTable = tableList.get(0);
				
				tableStrBuf.append("INTO " + dbTable.name);
				
				fieldStrBuf.append("SET ");
				
				for(DbField field : fieldList){
					if(field.table == dbTable){
						fieldCount++;
						fieldStrBuf.append(field.name + "=" + field.getValueString() + ",");
					}
				}
				if(fieldCount>0){
					fieldStrBuf.deleteCharAt(fieldStrBuf.length()-1);
				}

				isPrepared = true;
				
				return true;
//				break;
			case DELETE :
				if(tableList.size() == 1){
					tableStrBuf.append("FROM " + tableList.get(0).name);
				}else{
					
					//这里定义为：一个临时创建的没有fieldMaps的DbTable为只引用而不删除的表
					for(DbTable table : tableList){
						if(!table.fieldMaps.isEmpty()){
							tableStrBuf.append(table.name + ",");
						}
					}
					
					tableStrBuf.setCharAt(tableStrBuf.length()-1, ' ');
					
					tableStrBuf.append("FROM ");
					
					for(DbTable table : tableList){
						tableStrBuf.append(table.name + ",");
					}
					
					tableStrBuf.deleteCharAt(tableStrBuf.length()-1);
				}
				
				break;
			case UPDATE :
				
				if((fieldList==null) || (fieldList.size() == 0)){
					return false;
				}
				
				for(DbTable table : tableList){
					tableStrBuf.append(" " + table.name + ",");
				}

				tableStrBuf.setLength(tableStrBuf.length()-1);
				
				fieldStrBuf.append("SET");
				
				if(withTablePrefix){
					for(DbField field : fieldList){
						fieldStrBuf.append(field.table.name + "." + field.name + "=" 
								+ field.getValueString() + ",");
					}
				}else{
					for(DbField field : fieldList){
						fieldStrBuf.append(field.name + "=" + field.getValueString() + ",");
					}
				}
				
				fieldStrBuf.setLength(fieldStrBuf.length()-1);
				break;
			case SELECT :
				
				if((fieldList==null) || (fieldList.size() == 0)){
					fieldStrBuf.append(" * ");
				}else{
					if(withTablePrefix){
						for(DbField field : fieldList){
							fieldStrBuf.append(field.table.name + "." + field.name + " AS '" 
									+ field.table.name + "." + field.name + "',");
						}
					}else{
						for(DbField field : fieldList){
							fieldStrBuf.append(field.name + ",");
						}
					}
					fieldStrBuf.setLength(fieldStrBuf.length()-1);
				}

				tableStrBuf.append("FROM ");
				
				for(DbTable table : tableList){
					tableStrBuf.append(table.name + ",");
				}
				
				tableStrBuf.setLength(tableStrBuf.length()-1);
				break;
			case DROP :
				break;
				
			default :
				break;
		}
		
		
		if(conditionList != null){
			condStrBuf.append("WHERE 1 = 1");
			for(SqlCondition cond : conditionList){
				condStrBuf.append(cond.toString(withTablePrefix));
			}
		}
		
		if(orderByMap!=null && orderByMap.size() > 0){
			
			condStrBuf.append(" ORDER BY ");
			
			Set<String> keys = orderByMap.keySet();
			for(String fieldName : keys){
				condStrBuf.append(fieldName + " " + orderByMap.get(fieldName) + ",");
			}
			condStrBuf.setLength(condStrBuf.length()-1);
		}
		
		isPrepared = true;

		return true;
	}
	
	public String generateSql(int sqlOper, Integer rowCount, Integer offset){
		
		if(tableList.isEmpty()){
			return null;
		}
		
		StringBuffer sqlbuf = new StringBuffer();
		
		sqlbuf.append(SQL_OPERATORS[sqlOper]);
		
		switch(sqlOper){
		
		case CREATE :
			
			break;
		case REPLACE :
		case INSERT :
			
			if((fieldList==null) || (fieldList.size() == 0)){
				return null;
			}
			
			int fieldCount = 0;
			DbTable dbTable = tableList.get(0);
			
			sqlbuf.append(" INTO " + dbTable.name + " SET");
			
			for(DbField field : fieldList){
				if(field.table == dbTable){
					fieldCount++;
					sqlbuf.append(" " + field.name + "=" + field.getValueString() + ",");
				}
			}
			if(fieldCount>0){
				sqlbuf.deleteCharAt(sqlbuf.length()-1);
				return sqlbuf.toString();
			}else{
				return null;
			}
//				break;
		case DELETE :
			if(tableList.size() == 1){
				sqlbuf.append(" FROM " + tableList.get(0).name);
			}else{
				
				//这里定义为：一个临时创建的没有fieldMaps的DbTable为只引用而不删除的表
				for(DbTable table : tableList){
					if(!table.fieldMaps.isEmpty()){
						sqlbuf.append(" " + table.name + ",");
					}
				}
				
				sqlbuf.setCharAt(sqlbuf.length()-1, ' ');
				
				sqlbuf.append("FROM");
				
				for(DbTable table : tableList){
					sqlbuf.append(" " + table.name + ",");
				}
				
				sqlbuf.deleteCharAt(sqlbuf.length()-1);
			}
			
			break;
		case UPDATE :
			
			if((fieldList==null) || (fieldList.size() == 0)){
				return null;
			}
			
			for(DbTable table : tableList){
				sqlbuf.append(" " + table.name + ",");
			}
			
			sqlbuf.setCharAt(sqlbuf.length()-1, ' ');
			
			sqlbuf.append("SET");
			
			if(withTablePrefix){
				for(DbField field : fieldList){
					sqlbuf.append(" " + field.table.name + "." + field.name + "=" 
							+ field.getValueString() + ",");
				}
			}else{
				for(DbField field : fieldList){
					sqlbuf.append(" " + field.name + "=" + field.getValueString() + ",");
				}
			}
			
			sqlbuf.setLength(sqlbuf.length()-1);
			break;
		case SELECT :
			
			if((fieldList==null) || (fieldList.size() == 0)){
				sqlbuf.append(" * ");
			}else{
				if(withTablePrefix){
					for(DbField field : fieldList){
						sqlbuf.append(" " + field.table.name + "." + field.name + " AS '" 
								+ field.table.name + "." + field.name + "',");
					}
				}else{
					for(DbField field : fieldList){
						sqlbuf.append(" " + field.name + ",");
					}
				}
				sqlbuf.setCharAt(sqlbuf.length()-1, ' ');
			}
			
			sqlbuf.append("FROM");
			
			for(DbTable table : tableList){
				sqlbuf.append(" " + table.name + ",");
			}
			
			sqlbuf.setLength(sqlbuf.length()-1);
			break;
		case DROP :
			break;
			
		default :
			break;
		}
		
		
		if(conditionList != null){
			sqlbuf.append(" WHERE 1 = 1");
			for(SqlCondition cond : conditionList){
				sqlbuf.append(cond.toString(withTablePrefix));
			}
		}
		
		if(orderByMap!=null && orderByMap.size() > 0){
			
			sqlbuf.append(" ORDER BY ");
			
			Set<String> keys = orderByMap.keySet();
			for(String fieldName : keys){
				sqlbuf.append(fieldName + " " + orderByMap.get(fieldName) + ",");
			}
			sqlbuf.setLength(sqlbuf.length()-1);
		}
		
		if(rowCount != null){
			sqlbuf.append(" LIMIT " + rowCount);
			if(offset != null){
				sqlbuf.append(" OFFSET " + offset);
			}
		}
		
		return sqlbuf.toString();
	}
	
	public String generateSql(int sqlOper){
		return generateSql(sqlOper, null, null);
	}
	
	public String generateSql(int sqlOper, Integer rowCount){
		return generateSql(sqlOper, rowCount, null);
	}
	
	
	public String getSelectCountSql(){
		StringBuffer sqlbuf = new StringBuffer();
		if(prepareSql(SELECT)){
			sqlbuf.append(sqlOperStr);
			sqlbuf.append(" count(*) ");
			sqlbuf.append(tableStrBuf);
			sqlbuf.append(" " + condStrBuf);
		}
		return sqlbuf.toString();
	}
	
	public String getSelectSql(){
		return generateSql(SELECT, null, null);
	}
	
	public String getSelectSql(Integer rowCount, Integer offset){
		
		StringBuffer sqlbuf = new StringBuffer();
		
		if(prepareSql(SELECT)){
			sqlbuf.append(sqlOperStr);
			sqlbuf.append(" " + fieldStrBuf);
			sqlbuf.append(tableStrBuf);
			sqlbuf.append(" " + condStrBuf);
			sqlbuf.append(" LIMIT " + rowCount);
			sqlbuf.append(" OFFSET " + offset);
		}
//		return generateSql(SELECT, rowCount, offset);
		return sqlbuf.toString();
	}
	
	public String getUpdateSql(){
		return generateSql(UPDATE, null, null);
	}
	
	public String getUpdateSql(Integer rowCount){
		return generateSql(UPDATE, rowCount, null);
	}
	
	public String getDeleteSql(){
		return generateSql(DELETE, null, null);
	}
	
	public String getDeleteSql(Integer rowCount){
		return generateSql(DELETE, rowCount, null);
	}
	
	public String getInsertSql(){
		return generateSql(INSERT, null, null);
	}
	
	public String getReplaceSql(){
		return generateSql(REPLACE, null, null);
	}
	
	public int execSql(int sqlOper){
		
		int result = 0;
		
		switch(sqlOper){
		
			case CREATE :
				break;
			case REPLACE :
			case INSERT :
				break;
			case DELETE :
				break;
			case UPDATE :
				break;
			case SELECT :
				break;
			case DROP :
				break;
				
			default :
				break;
		}
		
		return result;
	}

}
