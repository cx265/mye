package priv.cx.carl.spring.ws;

import org.springframework.stereotype.Component;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年10月26日 下午3:55:59
 */
@Component("parkingWebService")
public class ParkingWebService {

	public String springHello(String[] name) {
		return "hello " + name[0];
	}

}
