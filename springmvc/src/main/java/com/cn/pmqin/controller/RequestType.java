package com.cn.pmqin.controller;


public class RequestType {
	
	public String access_token;
	public RequestTypeBody request_body;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public RequestTypeBody getRequest_body() {
		return request_body;
	}

	public void setRequest_body(RequestTypeBody request_body) {
		this.request_body = request_body;
	}
	
	
}
