
package priv.carl.cx.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloWSImpl", targetNamespace = "http://ws.cx.carl.priv/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloWSImpl {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://ws.cx.carl.priv/", className = "priv.carl.cx.ws.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://ws.cx.carl.priv/", className = "priv.carl.cx.ws.SayHelloResponse")
    @Action(input = "http://ws.cx.carl.priv/HelloWSImpl/sayHelloRequest", output = "http://ws.cx.carl.priv/HelloWSImpl/sayHelloResponse")
    public String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
