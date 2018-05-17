package cap.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cap.bean.Customer;
import cap.bean.Orders;
import cap.util.HibernateUtil;

public class Test1 {
	
	@Test
	public void save1(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = new Customer("cx123","1221");
		Orders orders = new Orders("2016-1-1","2");
		customer.setOrders(orders);
		orders.setCustomer(customer);
		session.save(customer);
		transaction.commit();
		session.close();
	}

}
