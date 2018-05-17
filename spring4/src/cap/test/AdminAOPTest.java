package cap.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cap.bean.Admin;
import cap.dao.AdminDAO;

public class AdminAOPTest {
	private ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	AdminDAO adminDAO = (AdminDAO) context.getBean("adminDAO");

	@Test
	public void testAddAdminWithAOP() {
		Admin admin = new Admin("cx","123");
		adminDAO.addAdmin(admin);
	}
}
