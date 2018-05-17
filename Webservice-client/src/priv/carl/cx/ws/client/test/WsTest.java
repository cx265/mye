package priv.carl.cx.ws.client.test;

import priv.carl.cx.ws.HelloWSImpl;
import priv.carl.cx.ws.HelloWSImplService;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年10月16日 下午9:11:06
 */
public class WsTest {
	
	public static void main(String[] args) {
		HelloWSImplService helloWSImplService = new HelloWSImplService();
		HelloWSImpl helloWSImpl = helloWSImplService.getHelloWSImplPort();
		String result = helloWSImpl.sayHello("Tom");
		System.out.println(result);
	}
	
}
