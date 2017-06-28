package com.abeliot.app.dao.db1.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.abeliot.app.dao.db1.TestDao;


@Service("db1.infoBiz")
public class InfoService {

	@Resource(name = "db1.testDao")
	public TestDao dao;
}
