package cap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cap.HelloWorld;
import cap.impl.HelloWorldImpl1;

@Configuration
public class AppConfig {
	
	@Bean(name="helloWorld")
	public HelloWorld getHelloWorld(){
		return new HelloWorldImpl1();
	}
}
