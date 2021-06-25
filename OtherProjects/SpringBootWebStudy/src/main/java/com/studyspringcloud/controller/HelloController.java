package com.studyspringcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private boolean yesOrNo = false;
	
	@GetMapping("/questionApi")
	public String getAnswer(@RequestParam(value="answer",defaultValue="Yes") String answer)
	{
		if(yesOrNo)
		{
			answer = "yes";
			yesOrNo = false;
		}
		else
		{
			answer = "no";
			yesOrNo = true;
		}
		return "{\"answer\":\""+answer+"\"}";
	}
	
}

