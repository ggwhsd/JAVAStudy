package com.studyspringcloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studyspringcloud.dao.PersonRepository;
import com.studyspringcloud.entity.Person;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonRepository personRepository;
	@Value("${server.port}")
	private String serverport;
	@RequestMapping("/all")
	public List<String> getMemberAll()
	{
		List<String> listUser = new ArrayList<String>();
		listUser.add("u1");
		listUser.add("u2");
		listUser.add("u3");
		listUser.add("u4");
		listUser.add(serverport);
		return listUser;
	}
	@RequestMapping("/{id}")
	public String findById(@PathVariable Long id)
	{
		Person findOne = this.personRepository.getOne(id);
		return findOne.toString();
	}
	
	
	@RequestMapping("/getApi")
	public String getPersonApi()
	{
		return "Eureka client 的 示例工程";
	}
	
}
