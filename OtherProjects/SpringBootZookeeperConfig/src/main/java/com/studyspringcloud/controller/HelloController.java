package com.studyspringcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Value("${msg:defaultMsg}")
	private String msg;
	
	@Value("${msg1:defaultMsg}")
	private String msg1;
	
	@Value("${msg2:defaultMsg}")
	private String msg2;
	@RequestMapping(value="/getMsg")
	public String getMsg()
	{
		return "这是来自配置中心的信息,用户名为"+msg+","+msg1+","+msg2;
	}
	
}
