package com.cx.carl.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {

	@RequestMapping(value="/helloworld")
	public String hello(){
		System.out.println("hello world");
		return "success";
	}

}
