package priv.cx.carl.spring.test;

import java.rmi.RemoteException;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import priv.cx.carl.spring.ws.ParkingServiceStub;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年10月27日 下午2:04:02
 */
public class WebserviceTest {

	public static void main(String[] args) {
		testRPCClient();
	}

	public static void testRPCClient() {
		try {
			String url = "http://10.140.220.1:8080/Webservice-server-axis2/services/parkingService?wsdl";
			// 使用RPC方式调用WebService
			RPCServiceClient serviceClient = new RPCServiceClient();
			// 指定调用WebService的URL
			EndpointReference targetEPR = new EndpointReference(url);
			Options options = serviceClient.getOptions();
			// 确定目标服务地址
			options.setTo(targetEPR);

			QName qname = new QName("http://ws.spring.carl.cx.priv", "springHello");
			Object[] parameters = new Object[] { new String[]{ "Jack" } };
			Class[] returnTypes = new Class[] { String.class };

			Object[] response = serviceClient.invokeBlocking(qname, parameters, returnTypes);
			String result = (String) response[0];
			System.out.println(result);
			/*OMElement element = serviceClient.invokeBlocking(qname, parameters);
			String result = element.getFirstElement().getText();
			System.out.println(result);*/
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}

	public static void testRPCClient2() {
		try {
			String url = "http://10.10.70.170:8080/Webservice-server-axis2/services/parkingService?wsdl";
			ParkingServiceStub factory = new ParkingServiceStub(url);
			ParkingServiceStub.SpringHello input = new ParkingServiceStub.SpringHello();
			input.setName("Tom");
			ParkingServiceStub.SpringHelloResponse output = factory.springHello(input);
			String str = output.get_return();
			System.out.println("str = " + str);
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
