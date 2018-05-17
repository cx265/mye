package com.atguigu.day01_ws.interceptor;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;

/**
 * 查检用户的拦截器
 * 
 * @author xfzhang
 *
 */
public class CheckUserInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	public CheckUserInterceptor() {
		super(Phase.PRE_PROTOCOL);
	}

	/*
	 * <Envelope> <head> <atguigu> <name>xfzhang</name>
	 * <password>123456</password> </atguigu> <atguigu2> <name>xfzhang</name>
	 * <password>123456</password> </atguigu2> <head> <Body> <sayHello>
	 * <arg0>BOB</arg0> <sayHello> </Body> </Envelope>
	 */
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		Header header = message.getHeader(new QName("atguigu"));
		if (header != null) {
			Element atguiguEle = (Element) header.getObject();
			String name = atguiguEle.getElementsByTagName("name").item(0).getTextContent();
			String password = atguiguEle.getElementsByTagName("password").item(0).getTextContent();
			if ("xfzhang".equals(name) && "123456".equals(password)) {
				System.out.println("Server 通过拦截器....");
				return;
			}
		}
		// 不能通过
		System.out.println("Server 没有通过拦截器....");
		throw new Fault(new RuntimeException("请求需要一个正确的用户名和密码!"));
	}

}
