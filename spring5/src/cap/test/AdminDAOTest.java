package cap.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cap.bean.Admin;
import cap.dao.AdminDAO;
import cap.dao.impl.AdminDAOImpl1;

public class AdminDAOTest {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	AdminDAO adminDAO2 = (AdminDAO) context.getBean("adminDAO2");
	AdminDAO adminDAO3 = (AdminDAO) context.getBean("adminDAO3");

	@Test
	public void testAddAdmins() {
		AdminDAO adminDAO = new AdminDAOImpl1();
		Admin admin = new Admin("ccc", "111");
		adminDAO.addAdmin(admin);
	}

	@Test
	public void testAddAdmins2() {
		Admin admin = new Admin("cccx", "111222");
		adminDAO2.addAdmin(admin);
	}
	
	@Test
	public void testAddAdmins3() {
		Admin admin = new Admin("zzz", "333");
		adminDAO3.addAdmin(admin);
	}

	@Test
	public void testFindAll() {
		List<Admin> admins = adminDAO2.getAdmins();
		/*
		 * for(Admin admin:admins){
		 * System.out.println(admin.getId()+":"+admin.getUsername
		 * ()+":"+admin.getPassword()); }
		 */
		for (int i = 0; i < admins.size(); i++) {
			Admin admin = admins.get(i);
			System.out.println(admin.getId() + ":" + admin.getUsername() + ":"
					+ admin.getPassword());
		}
	}
	
	@Test
	public void testDelAdmin(){
		adminDAO3.delAdmin(2);
	}

}
