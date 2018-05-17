package priv.cx.carl.ws;

import javax.jws.WebService;

import priv.cx.carl.bean.Order;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年10月24日 下午9:16:04
 */
@WebService(targetNamespace="http://ws.carl.cx.priv/",name="OrderWSImpl", serviceName="OrderWSImplService")
public class OrderWSImpl implements OrderWS {
	
	@Override
	public Order getOrderById(int id) {
		System.out.println("server getOrderById() "+id);
		return new Order(id, "书本", 100.00);
	}

}
