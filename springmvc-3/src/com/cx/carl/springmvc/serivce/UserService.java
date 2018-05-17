package com.cx.carl.springmvc.serivce;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	/*
	 * Spring IOC 容器中的 bean 却不能来引用 SpringMVC IOC 容器中的 bean!
	 */
//	@Autowired
//	private HelloWorld helloWorld;
	
	public UserService(){
		System.out.println("UserService");
	}
}
