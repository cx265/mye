package cap.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cap.bean.Order;
import cap.bean.Product;
import cap.util.HibernateUtil;

public class Test1 {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void save1(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Product product1 = new Product();
		Order order1 = new Order("2016-5-5");
		Order order2 = new Order("2016-5-6");
		product1.setName("iphone");
		product1.setPrice(1233);
		product1.getOrders().add(order1);
		product1.getOrders().add(order2);
		order1.getProducts().add(product1);
		order2.getProducts().add(product1);
		
		Product product2 = new Product();
		product2.setName("ipad");
		product2.setPrice(345);
		product2.getOrders().add(order1);
		order1.getProducts().add(product2);
		session.save(order1);
		session.save(order2);
		transaction.commit();
		session.close();
	}

}
