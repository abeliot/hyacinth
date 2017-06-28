package com.abeliot.framework.base;


public abstract class BatchDao<T> extends BaseDao<T>{
	
	protected BatchDao(Class<T> clazz){
		super(clazz);
	}

}
