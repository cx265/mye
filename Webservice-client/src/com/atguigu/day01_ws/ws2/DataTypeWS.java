package com.atguigu.day01_ws.ws2;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.5.9
 * 2014-03-11T15:55:33.017+08:00
 * Generated source version: 2.5.9
 * 
 */
@WebService(targetNamespace = "http://ws2.day01_ws.atguigu.com/", name = "DataTypeWS")
@XmlSeeAlso({ObjectFactory.class})
public interface DataTypeWS {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getStudentById", targetNamespace = "http://ws2.day01_ws.atguigu.com/", className = "com.atguigu.day01_ws.ws2.GetStudentById")
    @WebMethod
    @ResponseWrapper(localName = "getStudentByIdResponse", targetNamespace = "http://ws2.day01_ws.atguigu.com/", className = "com.atguigu.day01_ws.ws2.GetStudentByIdResponse")
    public com.atguigu.day01_ws.ws2.Student getStudentById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0
    );

    @WebResult(name = "_return", targetNamespace = "")
    @RequestWrapper(localName = "getAllStudentsMap", targetNamespace = "http://ws2.day01_ws.atguigu.com/", className = "com.atguigu.day01_ws.ws2.GetAllStudentsMap")
    @WebMethod
    @ResponseWrapper(localName = "getAllStudentsMapResponse", targetNamespace = "http://ws2.day01_ws.atguigu.com/", className = "com.atguigu.day01_ws.ws2.GetAllStudentsMapResponse")
    public com.atguigu.day01_ws.ws2.GetAllStudentsMapResponse.Return getAllStudentsMap();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "addStudent", targetNamespace = "http://ws2.day01_ws.atguigu.com/", className = "com.atguigu.day01_ws.ws2.AddStudent")
    @WebMethod
    @ResponseWrapper(localName = "addStudentResponse", targetNamespace = "http://ws2.day01_ws.atguigu.com/", className = "com.atguigu.day01_ws.ws2.AddStudentResponse")
    public boolean addStudent(
        @WebParam(name = "arg0", targetNamespace = "")
        com.atguigu.day01_ws.ws2.Student arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getStudentsByPrice", targetNamespace = "http://ws2.day01_ws.atguigu.com/", className = "com.atguigu.day01_ws.ws2.GetStudentsByPrice")
    @WebMethod
    @ResponseWrapper(localName = "getStudentsByPriceResponse", targetNamespace = "http://ws2.day01_ws.atguigu.com/", className = "com.atguigu.day01_ws.ws2.GetStudentsByPriceResponse")
    public java.util.List<com.atguigu.day01_ws.ws2.Student> getStudentsByPrice(
        @WebParam(name = "arg0", targetNamespace = "")
        float arg0
    );
}
