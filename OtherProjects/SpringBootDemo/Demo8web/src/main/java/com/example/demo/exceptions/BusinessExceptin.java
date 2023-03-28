package com.example.demo.exceptions;

public class BusinessExceptin extends RuntimeException {
	private Integer code; //用以区分业务异常
	public Integer getCode() {
		return code;
	}
	public BusinessExceptin(Integer code,String message)
	{
		super(message);
		this.code = code;
	}
	public BusinessExceptin(Integer code,String message, Throwable cause)
	{
		super(message,cause);
		this.code = code;
	}
}
