package cap.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cap.bean.Admin;
import cap.dao.AdminDAO;

public class AdminDAOTest {
	private ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	@Test
	public void testFindAdmins() {
		AdminDAO adminDAO = (AdminDAO) ctx.getBean("adminDAO");
		List<Admin> adminList = adminDAO.findAdmins();
		for (Admin admin : adminList) {
			System.out.println(admin.getUsername());
		}
	}

	@Test
	public void testAddAdmin() {
		AdminDAO adminDAO = (AdminDAO) ctx.getBean("adminDAO");
		Admin admin = new Admin();
		admin.setUsername("starlee2000");
		admin.setPassword("starlee2000");
		adminDAO.addAdmin(admin);

	}

	@Test
	public void testFindById() {
		AdminDAO adminDAO = (AdminDAO) ctx.getBean("adminDAO");
		Admin admin = adminDAO.findById(1);
		System.out.println(admin.getUsername());

	}

	@Test
	public void testDeleteAdmin() {
		AdminDAO adminDAO = (AdminDAO) ctx.getBean("adminDAO");
		int res = adminDAO.deleteAdmin(3);
		if (res > 0)
			System.out.println("删除成功");
		else
			System.out.println("删除失败");

	}

	@Test
	public void testUpdateAdmin() {
		AdminDAO adminDAO = (AdminDAO) ctx.getBean("adminDAO");
		Admin admin = new Admin();
		admin.setId(3);
		admin.setUsername("starlee2015");
		admin.setPassword("starlee2015");
		int res = adminDAO.updateAdmin(admin);
		if (res > 0)
			System.out.println("更新成功");
		else
			System.out.println("更新成功");

	}

}
