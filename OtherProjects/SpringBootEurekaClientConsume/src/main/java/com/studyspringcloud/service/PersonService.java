package com.studyspringcloud.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonService {
	private int i = 0;
	
	@Resource
	private RestTemplate restTemplate;
	public List<String> getPersonAll()
	{
		i++;
		System.out.println("i="+i++);
		return restTemplate.getForObject("http://service-person/person/all", List.class);
	}
}
