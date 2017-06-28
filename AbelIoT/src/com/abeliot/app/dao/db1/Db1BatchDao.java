package com.abeliot.app.dao.db1;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

import com.abeliot.framework.base.BatchDao;


public abstract class Db1BatchDao<T> extends BatchDao<T>{

	
	protected Db1BatchDao(Class<T> clazz) {
		// TODO Auto-generated constructor stub
		super(clazz);
	}
	
	@Resource(name="db1.sqlSessionTemplateBatch")
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		super.sqlSession = sqlSession;
	}
}
