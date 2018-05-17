package cap.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import cap.bean.Admin;
import cap.util.HibernateUtil;

public class Test1 {
	
	

	@Test
	public void addTest(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Admin admin = new Admin("cx","12345",222);
		session.save(admin);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void getTest() {
		Session session = HibernateUtil.getSession();
		Admin a1 = (Admin) session.get(Admin.class, Integer.valueOf("1"));
		Admin a2 = (Admin) session.get(Admin.class, Integer.valueOf("1"));
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		a1.setPassword("8899");
		session.clear();
		System.out.println(a1.getPassword());
		session.close();
	}
	
	@Test
	public void updateTest() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Admin admin = new Admin("cx123","cx456",111);
		admin.setAge(333);
		session.saveOrUpdate(admin);
		transaction.commit();
		session.close();
		admin.setPassword("123456");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session2 = sessionFactory.openSession();
		Transaction transaction2 = session2.beginTransaction();
		session2.save(admin);
		transaction2.commit();
		session2.close();
	}
	
	@Test
	public void loadTest() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		//session不存在，查询数据库
		Admin admin = (Admin) session.load(Admin.class, 2);
		//直接在session中查找，和get相似
		Admin admin2 = (Admin) session.load(Admin.class, 2);
		//查询OID是不需要执行数据库查询
		System.out.println(admin.getId());
		//非OID则需要执行数据库查询
		System.out.println(admin.getUsername());
		transaction.commit();
		session.close();
	}
	
	@Test
	public void mergeTest() {
		Admin admin = new Admin();
		admin.setId(20);
		admin.setAge(99);;
		admin.setUsername("你好");
		admin.setPassword("66666");;
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.get(Admin.class, 20);
		Admin admin2 = (Admin) session.merge(admin);
		session.getTransaction().commit();
		session.close();
	}
}
