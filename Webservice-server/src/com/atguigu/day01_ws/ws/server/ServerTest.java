package com.atguigu.day01_ws.ws.server;

import javax.xml.ws.Endpoint;

import com.atguigu.day01_ws.ws.HelloWSImpl;

/*
 * 发布Web Service
 */
public class ServerTest {

	public static void main(String[] args) {

		String address = "http://192.168.10.165:8989/day01_ws/hellows";
		Endpoint.publish(address , new HelloWSImpl());
		System.out.println("发布webservice成功!");
	}
}
