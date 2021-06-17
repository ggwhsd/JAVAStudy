package com.studyspringcloud.controller;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {
	@Resource
    private RestTemplate restTemplate;
	@GetMapping("/loadbalanceuseribbon")
    public String loadbalanceuseribbon() {

        return this.restTemplate.getForObject("http://serviceprovider", String.class);
    }
}
