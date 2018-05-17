package com.cx.carl.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cx.carl.springmvc.serivce.UserService;

@Controller
public class HelloWorld {
	
	@Autowired
	private UserService userService;
	
	public HelloWorld() {
		System.out.println("HelloWorld");
	}

	@RequestMapping(value = "/helloWorld")
	public String hello(){
		System.out.println("success");
		return "success";
	}
}
