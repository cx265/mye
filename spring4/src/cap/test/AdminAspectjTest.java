package cap.test;

import org.aspectj.lang.annotation.Aspect;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cap.bean.Admin;
import cap.dao.AdminDAO;
@Aspect
public class AdminAspectjTest {
	private ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	AdminDAO adminDAO = (AdminDAO) context.getBean("adminDAO");

	@Test
	public void testAddAdminWithAOP() {
		Admin admin = new Admin("cx","cx123");
		adminDAO.addAdmin(admin);
	}
}
