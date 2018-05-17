package com.atguigu.day01_ws.ws;

import javax.jws.WebService;

/*
 * SEIµÄÊµÏÖ
 */
@WebService
public class HelloWSImpl implements HelloWS {

	@Override
	public String sayHello(String name) {
		System.out.println("server sayHello()"+name);
		return "Hello " +name;
	}

}
