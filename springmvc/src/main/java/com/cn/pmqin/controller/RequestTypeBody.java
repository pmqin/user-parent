package com.cn.pmqin.controller;

public class RequestTypeBody {
	public String dbName;
	public String retainDays;
	public String tableName;

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getRetainDays() {
		return retainDays;
	}

	public void setRetainDays(String retainDays) {
		this.retainDays = retainDays;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
