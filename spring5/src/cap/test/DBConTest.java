package cap.test;

import org.junit.AfterClass;
import org.junit.Test;

import cap.bean.Admin;
import cap.dao.AdminDAO;
import cap.dao.impl.AdminDAOImpl;

public class DBConTest {
	
	private AdminDAO adminDAO= new AdminDAOImpl(); 

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testAdd() {
		Admin admin = new Admin("cx","123");
		adminDAO.addAdmin(admin);
	}

}
