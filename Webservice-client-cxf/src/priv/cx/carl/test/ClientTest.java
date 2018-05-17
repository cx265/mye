package priv.cx.carl.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import priv.cx.carl.ws.Order;
import priv.cx.carl.ws.OrderWS;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年10月29日 上午10:42:01
 */
public class ClientTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext content = new ClassPathXmlApplicationContext(new String[] {"client-beans.xml"});
		OrderWS orderWS = (OrderWS) content.getBean("orderClient");
		Order order = orderWS.getOrderById(24);
		System.out.println(order);
	}
}
