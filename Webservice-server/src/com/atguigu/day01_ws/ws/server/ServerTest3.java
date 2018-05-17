package com.atguigu.day01_ws.ws.server;

import java.util.List;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws22.EndpointImpl;
import org.apache.cxf.message.Message;

import com.atguigu.day01_ws.ws.HelloWSImpl;

public class ServerTest3 {

	public static void main(String[] args) {
		String address = "http://192.168.10.165:8888/day01_ws/datatypews";
		Endpoint endpoint = Endpoint.publish(address , new HelloWSImpl());
		System.out.println(endpoint);
		EndpointImpl endpointImpl  = (EndpointImpl) endpoint;
		
		//服务端的日志入拦截器
		List<Interceptor<? extends Message>> inInterceptors = endpointImpl.getInInterceptors();
		inInterceptors.add(new LoggingInInterceptor());
		
		//服务端的日志出拦截器
		List<Interceptor<? extends Message>> outInterceptors = endpointImpl.getOutInterceptors();
		outInterceptors.add(new LoggingOutInterceptor());
		
		System.out.println("发布webservice成功!");
	}
}
