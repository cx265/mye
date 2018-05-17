package priv.carl.cx.ws.test;

import javax.xml.ws.Endpoint;

import priv.carl.cx.ws.HelloWSImpl;

/*
 * 发布Web Service
 */
public class ServerTest {

	public static void main(String[] args) {

		String address = "http://127.0.0.1:8080/ws/hellow";
		Endpoint.publish(address , new HelloWSImpl());
		System.out.println("发布webservice成功!");
	}
}
