package com.abeliot.test;

import java.util.Calendar;
import java.util.Date;

import com.abeliot.app.dao.db1.entity.Account;
import com.abeliot.app.dao.db1.entity.Info;
import com.abeliot.framework.base.BaseEntity;
import com.abeliot.framework.base.DbField;
import com.abeliot.framework.base.DbTable;
import com.abeliot.framework.base.SqlStatement;

public class Test {

	public static void main(String[] args) {
		Account account = new Account();
		Info info = new Info();
		SqlStatement sql = new SqlStatement();
		DbTable accountTable = BaseEntity.getDbTableMap(Account.class).dbTable;
		DbTable infoTable = info.tableMap.dbTable;
		sql.addDbTable(infoTable);
		sql.addDbTable(accountTable);
		sql.addDbTable(new DbTable("website", 0));
		DbField idField = accountTable.newField(Account.idField.dbFieldName, 1);
		DbField login_nameField = accountTable.newField(Account.login_nameField.dbFieldName);
		DbField display_nameField = accountTable.newField(Account.display_nameField.dbFieldName);
		DbField register_dateField = accountTable.newField(Account.register_dateField.dbFieldName);
		sql.addField(infoTable.newField("id", 4));
		sql.addField(infoTable.newField("name", "gsdff"));
		sql.addField(infoTable.newField("age", 32));
		sql.addField(infoTable.newField("sign_data", new byte[]{0x27,(byte) 0x84,0x79,0x2f, (byte) 0xa4, (byte) 0xce, (byte) 0xd8}));
		sql.addField(idField);
		sql.addField(login_nameField);
		sql.addCondition(accountTable.newField(Account.idField.dbFieldName), "=", infoTable.newField("id"));
		sql.addCondition(login_nameField, "=", "admin");
		sql.addCondition(accountTable.newField(Account.account_statusField.dbFieldName), "in", new Integer[]{0,1,2});
//		Date[] objArr = new Date[2];
		Date[] objArr = new Date[]{new Date(115,0,1), Calendar.getInstance().getTime()};
//		objArr[0] = new Date(115,0,1);
//		objArr[1] = Calendar.getInstance().getTime();
		sql.addCondition(register_dateField, "between", objArr);
		sql.addCondition(display_nameField, "like", "%ad%");
		sql.addCondition(infoTable.newField("sign_data", new byte[]{0x27,(byte) 0x84,0x79,0x2f, (byte) 0xa4, (byte) 0xce, (byte) 0xd8}), "=");
		sql.addOrderBy(idField, SqlStatement.OrderAsc);
		System.out.println(sql.getSelectSql());
		System.out.println(sql.getSelectCountSql());
		System.out.println(sql.getSelectSql(3,2));
		System.out.println(sql.getUpdateSql());
		System.out.println(sql.getUpdateSql(3));
		System.out.println(sql.getDeleteSql());
		System.out.println(sql.getDeleteSql(3));
		System.out.println(sql.getInsertSql());
		System.out.println(sql.getReplaceSql());
	}

}
