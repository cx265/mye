package priv.cx.carl.interceptor;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AddUserInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	private String name;
	private String password;
	
	public AddUserInterceptor(String name, String password) {
		super(Phase.PRE_PROTOCOL);//准备协议化时拦截
		this.name = name;
		this.password = password;
	}

	@Override
	public void handleMessage(SoapMessage msg) throws Fault {
		List<Header> headers = msg.getHeaders();
		DocumentBuilderFactory factory;
		DocumentBuilder builder;
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element rootEle = document.createElement("atguigu");
			Element nameELe = document.createElement("name");
			nameELe.setTextContent(name);
			rootEle.appendChild(nameELe);
			Element passwordELe = document.createElement("password");
			passwordELe.setTextContent(password);
			rootEle.appendChild(passwordELe);
			headers.add(new Header(new QName("atguigu"), rootEle));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		System.out.println("client handleMessage()....");
	}

}
