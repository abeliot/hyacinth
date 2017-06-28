package com.abeliot.app.dao.db1;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

import com.abeliot.framework.base.SimpleDao;


public abstract class Db1SimpleDao<T> extends SimpleDao<T>{


	protected Db1SimpleDao(Class<T> clazz) {
		// TODO Auto-generated constructor stub
		super(clazz);
	}
	
	@Resource(name="db1.sqlSessionTemplateSimple")
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		super.sqlSession = sqlSession;
	}
}
