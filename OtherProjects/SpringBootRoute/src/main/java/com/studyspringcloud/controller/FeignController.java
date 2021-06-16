package com.studyspringcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studyspringcloud.service.FeignService;


@RestController
public class FeignController {
	@Resource
    private FeignService feignService;

    // 服务消费者对位提供的服务
    @GetMapping(value = "/search/github")
    public String searchGithubRepoByStr(@RequestParam("str") String queryStr) {
        return feignService.searchRepo(queryStr);
    }
}
