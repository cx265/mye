package cap.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import cap.service.HelloWorld;

public class HelloWorldTest {

	@Test
	public void testSayHi() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
		System.out.print(helloWorld.sayHi("starlee"));

	}

	@Test
	public void xmlBeanSayHi() {
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		HelloWorld helloWorld = (HelloWorld) factory.getBean("helloWorld");
		System.out.print(helloWorld.sayHi("starlee"));

	}

	@Test
	public void fileXMlSayHi() {
		ApplicationContext factory = new FileSystemXmlApplicationContext(
				"src/applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) factory.getBean("helloWorld");
		System.out.print(helloWorld.sayHi("starlee"));

	}

	@Test
	public void testStaticFactory() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld1");
		System.out.print(helloWorld.sayHi("starlee"));
	}

	@Test
	public void testFactoryMethod() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld2");
		System.out.print(helloWorld.sayHi("starlee"));
	}

	@Test
	public void testBeanSingletonScope() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		HelloWorld helloWorld1 = (HelloWorld) context.getBean("helloWorld");
		HelloWorld helloWorld2 = (HelloWorld) context.getBean("helloWorld");
		if (helloWorld1.equals(helloWorld2)) {
			System.out.println("Spring Bean的作用域默认为singleton，所以helloWorld1和helloWorld2是同一个对象");
		}

	}

	@Test
	public void testBeanPrototypeScope() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		HelloWorld helloWorld1 = (HelloWorld) context.getBean("helloWorld3");
		HelloWorld helloWorld2 = (HelloWorld) context.getBean("helloWorld3");
		if (helloWorld1.equals(helloWorld2)) {
			System.out.println("Spring Bean的作用域默认为singleton，所以helloWorld1和helloWorld2是同一个对象");
		} else {
			System.out.println("Spring Bean的作用域为prototype，所以helloWorld1和helloWorld2是不同的对象");
		}

	}

}
