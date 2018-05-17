package cap.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cap.bean.Customer;
import cap.bean.Orders;
import cap.util.HibernateUtil;

public class Test1 {

	@org.junit.Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void save1(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = new Customer("cx","12312313");
		session.save(customer);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void save2(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = new Customer("cx","12312313");
		Orders orders = new Orders("2016-5-5");
		Orders orders2 = new Orders("2016-5-6");
		customer.getOrders().add(orders);
		orders.setCustomerId(customer);
		customer.getOrders().add(orders2);
		orders2.setCustomerId(customer);
		session.save(customer);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void queryTest(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, Integer.valueOf(2));
		System.out.println(customer.getName());
		Set<Orders> orders = customer.getOrders();
		for(Orders order:orders){
			System.out.println(order.getDate());
		}
		transaction.commit();
		session.close();
	}
	
	@Test
	public void queryByOrderTest(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Orders order = (Orders) session.get(Orders.class, Integer.valueOf(1));
		System.out.println(order.getCustomerId().getName()+":"+order.getDate());
		transaction.commit();
		session.close();
	}

}
