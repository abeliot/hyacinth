package com.abeliot.framework.base;


import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;


public abstract class BaseDao<T> {

	protected Class<T> clazz;
	protected String namespace;
	protected SqlSessionTemplate sqlSession;
	
	private static final String baseMapNamespace = "com.abeliot.framework.base";
	
	protected BaseDao(Class<T> clazz) {
		// TODO Auto-generated constructor stub
		this.clazz = clazz;
		this.namespace = clazz.getName();
//		System.out.println(clazz.getSimpleName() + ".namespace = " +this.namespace);
	}
	
	public int deleteById(Object id){
		return sqlSession.delete(this.namespace + ".deleteById", id);
	}
	
	public T queryById(Object id){
		return sqlSession.selectOne(this.namespace + ".queryById", id);
	}
	
	public List<T> queryList(String sql){
		return sqlSession.selectList(this.namespace + ".queryList", sql);
	}
	
	public List<T> queryList(SqlStatement sql){
		return sqlSession.selectList(this.namespace + ".queryList", sql.getSelectSql());
	}
	
	public PageList<T> queryPageList(SqlStatement sql, int pageSize, int pageIndex){
		
		int count = sqlSession.selectOne(baseMapNamespace + ".generalCountSelect", sql.getSelectCountSql());
		
		if(pageSize > count){
			pageSize = count;
			pageIndex = 1;
		}
		
		List<T> objList = sqlSession.selectList(this.namespace + ".queryList"
				, sql.getSelectSql(pageSize, (pageIndex - 1) * pageSize));
		
		PageList<T> pageList = new PageList<T>(count, pageSize, pageIndex, objList);
		
		return pageList;
	}
	
	public int replaceObj(T t){
		return sqlSession.insert(this.namespace + ".replaceObj", t);
	}
	
	public int insertObj(T t){
		return sqlSession.insert(this.namespace + ".insertObj", t);
	}
	
	public int updateObj(T t){
		return sqlSession.update(this.namespace + ".updateObj", t);
	}
	
	public int insert(String sql){
		return sqlSession.insert(baseMapNamespace + ".generalInsert", sql);
	}
	
	public int insert(SqlStatement sql){
		return sqlSession.insert(baseMapNamespace + ".generalInsert", sql.getInsertSql());
	}
	
	public int replace(String sql){
		return sqlSession.insert(baseMapNamespace + ".generalReplace", sql);
	}
	
	public int replace(SqlStatement sql){
		return sqlSession.insert(baseMapNamespace + ".generalReplace", sql.getReplaceSql());
	}
	
	public int delete(String sql){
		return sqlSession.delete(baseMapNamespace + ".generalDelete", sql);
	}
	
	public int delete(SqlStatement sql){
		return sqlSession.delete(baseMapNamespace + ".generalDelete", sql.getDeleteSql());
	}
	
	public int update(String sql){
		return sqlSession.update(baseMapNamespace + ".generalUpdate", sql);
	}
	
	public int update(SqlStatement sql){
		return sqlSession.update(baseMapNamespace + ".generalUpdate", sql.getUpdateSql());
	}
	
	public int selectCount(String sql){
		return sqlSession.selectOne(baseMapNamespace + ".generalCountSelect", sql);
	}
	
	public int selectCount(SqlStatement sql){
		return sqlSession.selectOne(baseMapNamespace + ".generalCountSelect", sql.getSelectCountSql());
	}
	
	public HashMap<String, Object> selectOne(String sql){
		return sqlSession.selectOne(baseMapNamespace + ".generalSelect", sql);
	}
	
	public HashMap<String, Object> selectOne(SqlStatement sql){
		return sqlSession.selectOne(baseMapNamespace + ".generalSelect", sql.getSelectSql());
	}
	
	public List<HashMap<String, Object>> selectList(String sql){
		return sqlSession.selectList(baseMapNamespace + ".generalSelect", sql);
	}
	
	public List<HashMap<String, Object>> selectList(SqlStatement sql){
		return sqlSession.selectList(baseMapNamespace + ".generalSelect", sql.getSelectSql());
	}
	
	public PageList<HashMap<String, Object>> selectPageList(SqlStatement sql, int pageSize, int pageIndex){
		
		int count = sqlSession.selectOne(baseMapNamespace + ".generalCountSelect", sql.getSelectCountSql());
		
		if(pageSize > count){
			pageSize = count;
			pageIndex = 1;
		}
		
		List<HashMap<String, Object>> objList = sqlSession.selectList(baseMapNamespace + ".generalSelect"
				, sql.getSelectSql(pageSize, (pageIndex - 1) * pageSize));
		
		PageList<HashMap<String, Object>> pageList = new PageList<HashMap<String, Object>>(count, pageSize, pageIndex, objList);
		
		return pageList;
	}
	
}
