package cap.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cap.bean.Admin;
import cap.util.HibernateUtil;

public class Test1 {

	@Test
	public void addTest(){
		Session session = HibernateUtil.getSession();
		Admin admin = new Admin("cx","123",22);
		Transaction transaction = session.beginTransaction();
		session.save(admin);
		transaction.commit();session.close();
	}
}
