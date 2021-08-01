package com.example.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HelloController {

	Logger logger = LoggerFactory.getLogger((getClass()));
	
	@ResponseBody
	@RequestMapping("/")
	public String hello()
	{
		return "Hello World";
	}
	
	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();
	
	
	//访问动态页面
	@RequestMapping("/index")
	public ModelAndView helloTempalte()
	{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("index");
		modelAndView.addObject("time", (new Date()).toString());
		return modelAndView;
	}
	

}
