package com.atguigu.day01_ws_cxf_client.test;

import java.util.List;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.message.Message;

import com.atguigu.day01_ws.ws.HelloWS;
import com.atguigu.day01_ws.ws.HelloWSImplService;
import com.atguigu.day01_ws_cxf_client.interceptor.AddUserInterceptor;

/*
 * 测试自定义拦截器
 */
public class ClientTest3 {

	public static void main(String[] args) {
		HelloWSImplService factory = new HelloWSImplService();
		HelloWS hellWS = factory.getHelloWSImplPort();
		
		//发送请求的客户端对象
		Client client = ClientProxy.getClient(hellWS);
		//客户端的自定义出拦截器
		List<Interceptor<? extends Message>> outInterceptors = client.getOutInterceptors();
		outInterceptors.add(new LoggingOutInterceptor());
		
		String result = hellWS.sayHello("BOB");
		System.out.println("client "+result);
	}
}
