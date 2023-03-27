package com.gugwexample.demo1;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	////get方式请求，简单参数传递。
	@RequestMapping("/oneParameter")   
	@ResponseBody  
	public String hello1(String name,int age)
	{
		return "{'module':'"+name+"-"+age+"'}";
	}
	
	
////get方式请求，@RequestParam的使用。
	@RequestMapping("/oneParameter2")   
	@ResponseBody  
	public String hello2(@RequestParam("name") String userName,int age)
	{
		return "{'module':'"+userName+"-"+age+"'}";
	}
	
	@RequestMapping("/pojoParameter")   
	@ResponseBody  
	public String hello3(User user)
	{
		return "{'module':'"+user.getName()+"-"+user.getAge()+user.getAddress().getCity()+user.getAddress().getRoad()+"'}";
	}
	
	
	@RequestMapping("/array")   
	@ResponseBody 
	public String hello4(String[] names)
	{
		System.out.println(Arrays.toString(names));
		return "{'module':'springmvc'}";
	}

	@RequestMapping("/json")   
	@ResponseBody 
	public String hello5(@RequestBody List<String> names)
	{
		System.out.println((names));
		return "{'module':'json'}";
	}
	
	@RequestMapping("/date")   
	@ResponseBody 
	public String hello6(Date d, @DateTimeFormat(pattern="yyyy-MM-dd") Date d2)
	{
		System.out.println(d);
		System.out.println(d2);
		return "{'module':'"+d+"'}";
	}
	

	
}
