package com.abeliot.framework.base;

public abstract class SimpleDao<T> extends BaseDao<T> {
		
	protected SimpleDao(Class<T> clazz){
		super(clazz);
	}

}
