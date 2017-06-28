package com.abeliot.app.dao.db1;


import org.springframework.stereotype.Repository;

import com.abeliot.app.dao.db1.entity.Account;


@Repository("db1.accountDao")
public class AccountDao extends Db1SimpleDao<Account>{

	public AccountDao() {
		// TODO Auto-generated constructor stub
		super(Account.class);
	}
	
	public Account selectByLoginName(String loginName){
		
		return (Account)sqlSession.selectOne(this.namespace +".selectByLoginName", loginName);

	}
	
}
