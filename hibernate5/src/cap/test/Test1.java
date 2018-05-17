package cap.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.mchange.v2.codegen.bean.Property;

import cap.bean.Customer;
import cap.util.HibernateUtil;

public class Test1 {

	@Test
	public void query1() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "select c from Customer c where c.name like '%123%' ";
		List<Customer> customers = session.createQuery(hql).list();
		for (Customer customer : customers) {
			System.out.println(customer.getName());
		}
		transaction.commit();
		session.close();
	}

	@Test
	public void query2() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "select c from Customer c where c.name like ? ";
		List<Customer> customers = session.createQuery(hql).setParameter(0, "%123%").list();
		for (Customer customer : customers) {
			System.out.println(customer.getName());
		}
		transaction.commit();
		session.close();
	}

	@Test
	public void query3() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "select c from Customer c where c.name like :a ";
		List<Customer> customers = session.createQuery(hql).setParameter("a", "%123%").list();
		for (Customer customer : customers) {
			System.out.println(customer.getName());
		}
		transaction.commit();
		session.close();
	}
	
	@Test
	public void query4() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "select c from Customer c where c.id in(:a) ";
		List<Customer> customers = session.createQuery(hql).setParameterList("a", new Object[]{Integer.valueOf(1),Integer.valueOf(3)}).list();
		for (Customer customer : customers) {
			System.out.println(customer.getName());
		}
		transaction.commit();
		session.close();
	}
	
	@Test
	public void query5() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "from Customer ";
		//分页只要改变setFirstResult()起始页就行了
		List<Customer> customers = session.createQuery(hql).setFirstResult(0).setMaxResults(3).list();
		for (Customer customer : customers) {
			System.out.println(customer.getName());
		}
		transaction.commit();
		session.close();
	}
	
	@Test
	public void query6() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		List<Customer> customers =session.createCriteria(Customer.class).add(Restrictions.like("name", "%123%")).list();
		for (Customer customer : customers) {
			System.out.println(customer.getName());
		}
		transaction.commit();
		session.close();
	}
	
	@Test
	public void query7() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		List<Customer> customers =session.createCriteria(Customer.class).add(Restrictions.sqlRestriction("{alias}.name like '%123%' ")).list();
		for (Customer customer : customers) {
			System.out.println(customer.getName());
		}
		transaction.commit();
		session.close();
	}
	
	@Test
	public void query8() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		List<Customer> customers =session.createCriteria(Customer.class).add(Restrictions.sqlRestriction("{alias}.name like '%123%' ")).add(org.hibernate.criterion.Property.forName("id").in(new Object[]{Integer.valueOf(1),Integer.valueOf(3)})).list();
		for (Customer customer : customers) {
			System.out.println(customer.getName());
		}
		transaction.commit();
		session.close();
	}
	
	@Test
	public void query9() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		List<Customer> customers =session.createCriteria(Customer.class).add(org.hibernate.criterion.Property.forName("name").like("%123%")).addOrder(org.hibernate.criterion.Property.forName("id").desc()).list();
		for (Customer customer : customers) {
			System.out.println(customer.getName());
		}
		transaction.commit();
		session.close();
	}
	
	@Test
	public void query10() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = new Customer();
		customer.setName("cx1");
		List<Customer> customers = session.createCriteria(Customer.class).add(Example.create(customer)).list();
		for (Customer c : customers) {
			System.out.println(c.getName());
		}
		transaction.commit();
		session.close();
	}
	
	@Test
	public void query11() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class).add(org.hibernate.criterion.Property.forName("name").like("%123%"));
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		List<Customer> customers = detachedCriteria.getExecutableCriteria(session).list();
		for (Customer c : customers) {
			System.out.println(c.getName());
		}
		transaction.commit();
		session.close();
	}
	
	@Test
	public void query12() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		List<Customer> customers = session.createSQLQuery("select * from customer").addEntity(Customer.class).list();
		for (Customer c : customers) {
			System.out.println(c.getName());
		}
		transaction.commit();
		session.close();
	}

}
