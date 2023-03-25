package com.gugwexample.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mvc")
public class Mvc1Controller {
	
	@RequestMapping("/hello")   
	@ResponseBody  //设置返回值类型
	public String hello()
	{
		
		return "{'module':'springmvc'}";
	}
}
