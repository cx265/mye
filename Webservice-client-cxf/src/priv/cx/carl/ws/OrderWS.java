package priv.cx.carl.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.13
 * 2017-10-29T10:39:12.568+08:00
 * Generated source version: 3.1.13
 * 
 */
@WebService(targetNamespace = "http://ws.carl.cx.priv/", name = "OrderWS")
@XmlSeeAlso({ObjectFactory.class})
public interface OrderWS {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getOrderById", targetNamespace = "http://ws.carl.cx.priv/", className = "priv.cx.carl.ws.GetOrderById")
    @WebMethod
    @ResponseWrapper(localName = "getOrderByIdResponse", targetNamespace = "http://ws.carl.cx.priv/", className = "priv.cx.carl.ws.GetOrderByIdResponse")
    public priv.cx.carl.ws.Order getOrderById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0
    );
}
