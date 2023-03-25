package com.gugwexample.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo1")
public class HelloController {
	
	@Autowired
	IBookService bookservice123;
	
	@RequestMapping("/hello")
	public String Hello()
	{
		bookservice123.save();
		return "Hello SpringBoot"+bookservice123.calcPrice(100);
	}
}
