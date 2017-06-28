package com.abeliot.app.dao.db1;


import org.springframework.stereotype.Repository;

import com.abeliot.app.dao.db1.entity.Info;


@Repository("db1.testDao")
public class TestDao extends Db1SimpleDao<Info>{

	
	public TestDao() {
		// TODO Auto-generated constructor stub
		super(Info.class);
	}
	
	
}
