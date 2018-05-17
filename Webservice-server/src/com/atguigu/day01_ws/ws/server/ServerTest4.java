package com.atguigu.day01_ws.ws.server;

import java.util.List;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.message.Message;

import com.atguigu.day01_ws.interceptor.CheckUserInterceptor;
import com.atguigu.day01_ws.ws.HelloWSImpl;

public class ServerTest4 {

	public static void main(String[] args) {
		String address = "http://127.0.0.1:8888/day01_ws/datatypews";
		Endpoint endpoint = Endpoint.publish(address , new HelloWSImpl());
		System.out.println(endpoint);
		EndpointImpl endpointImpl  = (EndpointImpl) endpoint;
		
		//服务端的入拦截器
		List<Interceptor<? extends Message>> inInterceptors = endpointImpl.getInInterceptors();
		inInterceptors.add(new CheckUserInterceptor());
		
		System.out.println("发布webservice成功!");
	}
}
