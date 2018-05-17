package cap.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cap.bean.Admin;

public class AdminTest {

	private ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAdmin1() {
		Admin admin = (Admin) context.getBean("admin1");
		System.out.println(admin.getId() + ":" + admin.getUsername() + ":"
				+ admin.getPassword());
	}

	@Test
	public void testAdmin2() {
		Admin admin = (Admin) context.getBean("admin2");
		System.out.println(admin.getId() + ":" + admin.getUsername() + ":"
				+ admin.getPassword());
	}

	@Test
	public void testAdmin3() {
		Admin admin = (Admin) context.getBean("admin3");
		System.out.println(admin.getId() + ":" + admin.getUsername() + ":"
				+ admin.getPassword());
	}

}
