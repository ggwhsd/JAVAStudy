package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class mvc1Controller {
	
	@RequestMapping("/hello")
	public String hello()
	{
		String pageName = "hello.html";
		return pageName;
	}
	
	@RequestMapping("/hello2")
	@ResponseBody
	public String hello2()
	{
		
		return "dfdfd";
	}
	
	@RequestMapping("/hello3")
	@ResponseBody
	public List<User> hello3()
	{
		List<User> users= new ArrayList<User>();
		
		User user = new User();
		user.setName("jerry");
		user.setAge(10);
		users.add(user);
		return users;
	}
}
