package com.studyspringcloud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studyspringcloud.service.PersonService;

@RestController
public class PersonServiceClientController {
	@Resource
	private PersonService personService;
	@RequestMapping("/getPersonAll")
	public List<String> getOrderUserAll(){
		return personService.getPersonAll();
	}
	@RequestMapping("/getOrderServiceApi")
	public String getOrderServiceApi()
	{
		return "这是服务Person消费者的Order工程";
	}
}
