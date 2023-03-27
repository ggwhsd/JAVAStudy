package com.example.demo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import  org.springframework.web.bind.annotation.PathVariable;
import  org.springframework.web.bind.annotation.RequestBody;
import  org.springframework.web.bind.annotation.RequestMapping;
import  org.springframework.web.bind.annotation.RequestMethod;
import  org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/users")
public class RestFulController {
     
     private List<User> users = new ArrayList();
     
     @RequestMapping(method=  RequestMethod.POST)
     public String save(@RequestBody User user)
     {
    	 System.out.println(user.getName());
          users.add(user);
          return "{'module':'user save'}";
     }
     @RequestMapping(value="/{id}", method =  RequestMethod.DELETE)
     //从路径中取变量赋值给id
     public String delete(@PathVariable String id)
     {
    	 for (int i = 0; i < users.size(); i++) {
    		 if(users.get(i).getName() == id)
    			 return "{'module':'user delete ok'}";
		}
    	 return "{'module':'user delete not found'}";
     }
     @RequestMapping( method =  RequestMethod.PUT)
     public String update(@RequestBody User user)
     {
    	 System.out.println(user.getName());
    	 for (int i = 0; i < users.size(); i++) {
    		 if(users.get(i).getName().equals(user.getName()))
    		 {
    			 users.set(i, user);
    			 return "{'module':'user update ok'}";
    		 }
    			 
		}
          return "{'module':'user update'}";
     }
     @RequestMapping(value="/{id}", method =  RequestMethod.GET)
     public User query(@PathVariable String id)
     {
    	 for (int i = 0; i < users.size(); i++) {
    		 if(users.get(i).getName().equals(id))
    			 return users.get(i);
		}
          return null;
     }
     @GetMapping
     public List<User> queryAll()
     {
    	
          return users;
     }
     
}