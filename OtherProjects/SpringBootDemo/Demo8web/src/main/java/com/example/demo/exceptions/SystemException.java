package com.example.demo.exceptions;

public class SystemException extends RuntimeException {
	private Integer code; //用以区分系统异常
	public Integer getCode() {
		return code;
	}
	public SystemException(Integer code,String message)
	{
		super(message);
		this.code = code;
	}
	public SystemException(Integer code,String message, Throwable cause)
	{
		super(message,cause);
		this.code = code;
	}

}
