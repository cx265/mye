package cap.service.impl;

import cap.service.HelloWorld;

public class HelloWorldBeanFactory implements HelloWorld {

	public static HelloWorld createHelloWorldBean() {
		return new HelloWorldImpl();
	}

	public HelloWorld createHelloWorldBean2() {
		return new HelloWorldImpl();
	}

	@Override
	public String sayHi(String name) {
		return "你好Spring" + name;
	}

}
