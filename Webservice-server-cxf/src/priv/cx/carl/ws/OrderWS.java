package priv.cx.carl.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import priv.cx.carl.bean.Order;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年10月24日 下午9:14:57
 */
@WebService
public interface OrderWS {

	@WebMethod(operationName="getOrderById")
	public Order getOrderById(int id);
}