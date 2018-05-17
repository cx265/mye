package cap.impl;

import org.springframework.stereotype.Component;

import cap.HelloWorld;
@Component("helloWorld")
public class HelloWorldImpl1 implements HelloWorld {

	@Override
	public String sayHi(String name) {
		return "你好" + name;
	}

}
