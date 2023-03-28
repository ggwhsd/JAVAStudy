package com.example.demo;

public class Result {
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getOpCode() {
		return opCode;
	}
	public void setOpCode(int opCode) {
		this.opCode = opCode;
	}
	public int getRetCode() {
		return retCode;
	}
	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	private int opCode;
	private int retCode;
	private String retMsg;
	private Object data;

	public Result(Object data, int opCode) {
		super();
		this.data = data;
		this.opCode = opCode;
		retCode = 0;
		retMsg = "";
	}
	public Result(Object data, int opCode, int retCode) {
		super();
		this.data = data;
		this.opCode = opCode;
		this.retCode = retCode;
		retMsg = "";
	}
	public Result(Object data, int opCode, int retCode, String retMsg) {
		super();
		this.data = data;
		this.opCode = opCode;
		this.retCode = retCode;
		this.retMsg = retMsg;
	}
}
