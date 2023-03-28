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
    
	public static final Integer SAVE_OPCODE =  101;
	public static final Integer DELETE_OPCODE =  102;
	public static final Integer UPDATE_OPCODE =  103;
	public static final Integer GET_OPCODE =  104;
	public static final Integer GETALL_OPCODE =  105;
	
	
     private List<User> users = new ArrayList();
     
     @RequestMapping(method=  RequestMethod.POST)
     public Result save(@RequestBody User user)
     {
    	 System.out.println(user.getName());
          users.add(user);
          
          return new Result(null,SAVE_OPCODE, ResultRetCode.OK, "save ok");
     }
     @RequestMapping(value="/{id}", method =  RequestMethod.DELETE)
     //从路径中取变量赋值给id
     public Result delete(@PathVariable String id)
     {
    	 for (int i = 0; i < users.size(); i++) {
    		 if(users.get(i).getName().equals(id))
    			 return new Result(null, DELETE_OPCODE, ResultRetCode.OK, "delete ok");
		}
    	 return new Result(null, DELETE_OPCODE, ResultRetCode.NOT_FOUND, "no record");
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
     public Result query(@PathVariable String id)
     {
    	 for (int i = 0; i < users.size(); i++) {
    		 if(users.get(i).getName().equals(id))
    			 return new Result(users.get(i), GET_OPCODE, ResultRetCode.OK, "");
		}
          return new Result(null, GET_OPCODE, ResultRetCode.NOT_FOUND, "no record");
     }
     @GetMapping
     public List<User> queryAll()
     {
    	
          return users;
     }
     
}