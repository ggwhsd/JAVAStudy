package com.example.demo;

public class ResultRetCode {
	public static final Integer OK =  0;
	//异常导致的保存错误
	public static final Integer SAVE_ERR =  1;
	//异常导致的更新错误
	public static final Integer DELETE_ERR =  2;
	public static final Integer UPDATE_ERR =  3;
	public static final Integer GET_ERR =  4;
	public static final Integer GETALL_ERR = 5;
	//找不到请求的记录
	public static final Integer NOT_FOUND = 6;
	//请求参数格式或者内容不满足校验
	public static final Integer PARAM_NOTVALID = 6;
}
