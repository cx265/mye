package cap.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cap.HelloWorld;
import cap.config.AppConfig;

public class HelloWorldTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testBean1() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
		System.out.println(helloWorld.sayHi("ccpp"));
	}
	
	@Test
	public void testBean2() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
		System.out.println(helloWorld.sayHi("ccpp"));
	}
	
	@Test
	public void testBean3() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
		System.out.println(helloWorld.sayHi("ccpp"));
	}

}
