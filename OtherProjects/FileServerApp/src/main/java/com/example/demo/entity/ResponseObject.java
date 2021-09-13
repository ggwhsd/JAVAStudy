package com.example.demo.entity;

import java.util.HashMap;
import java.util.Map;

public class ResponseObject {

	public ResponseObject()
	{
		values = new HashMap<String,Object>();
		
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getCodeDescribe() {
		return codeDescribe;
	}
	public void setCodeDescribe(String codeDescribe) {
		this.codeDescribe = codeDescribe;
	}
	public Map<String,Object> getValues() {
		return values;
	}
	
	public void put(String key, Object value)
	{
		values.put(key,value);
	}
	
	private int code;
	private String codeDescribe;

	private Map<String,Object> values;
	
}
