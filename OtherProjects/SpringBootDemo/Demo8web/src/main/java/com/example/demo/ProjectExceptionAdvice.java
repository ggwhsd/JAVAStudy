package com.example.demo;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exceptions.BusinessExceptin;
import com.example.demo.exceptions.SystemException;

@RestControllerAdvice
public class ProjectExceptionAdvice {
	
	@ExceptionHandler(Exception.class)  //针对所有异常
	public Result HandleException(Exception ex)
	{
		return new Result(null,  -1, -1, ex.getMessage());
	}
	
	@ExceptionHandler(SystemException.class)  
	public Result HandleSystemException(SystemException ex)
	{
		//todo:记录日志
		//todo:发送消息运维
		//todo:发送消息给开发
		return new Result(null,  -1, ex.getCode(), ex.getMessage());
	}
	
	@ExceptionHandler(BusinessExceptin.class)  
	public Result HandleBusinessExceptin(BusinessExceptin ex)
	{
		//todo:记录日志
		//todo:发送消息给运营、产品等可能的业务人员
		return new Result(null,  -1, ex.getCode(), ex.getMessage());
	}
}
