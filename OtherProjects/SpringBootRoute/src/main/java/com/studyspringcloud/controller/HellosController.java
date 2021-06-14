package com.studyspringcloud.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellosController {
	@GetMapping("/hellos/hello")
    public String hello() {
        return "Hello，我是Spring Boot。";
    }
	@GetMapping("/hellos/hello1")
    public String hello1() {
        return "Hello1，我是Spring Boot。";
    }
	@GetMapping("/hellos/hello2")
    public String hello2() {
        return "Hello2，我是Spring Boot。";
    }
	@GetMapping("/")
    public String helloRoot() {
        return "Hello root ，我是Spring Boot。";
    }
}
