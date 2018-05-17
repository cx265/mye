package priv.cx.carl.interceptor;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年10月25日 上午10:23:50
 */
public class CheckUserInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	public CheckUserInterceptor() {
		super(Phase.PRE_PROTOCOL);
	}
	
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		Header header = message.getHeader(new QName("atguigu"));
		if(header!=null) {
			Element root = (Element) header.getObject();
			String name = root.getElementsByTagName("name").item(0).getTextContent();
			String password = root.getElementsByTagName("password").item(0).getTextContent();
			if("cx".equals(name) && "123456".equals(password)) {
				System.out.println("Server 通过拦截器....");
				return;
			}
		}
		System.out.println("Server 没有通过拦截器....");
		throw new Fault(new RuntimeException("请求需要一个正确的用户名和密码!"));
	}
}
