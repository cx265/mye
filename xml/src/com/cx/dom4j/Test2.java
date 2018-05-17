package com.cx.dom4j;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

public class Test2 {

	/**
	 * @param args
	 * @throws DocumentException 
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static void main(String[] args) throws DocumentException, ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read("student.xml");
		Element root = document.getRootElement();
		System.out.println("root element:" + root.getName());
		List childList = root.elements();
		System.out.println(childList.size());
		System.out.println("----------------");
		List childList2 = root.elements("hello");
		System.out.println(childList2.size());
		Element first = root.element("world");
		System.out.println(first.attributeValue("age"));
		System.out.println("----------------");
		for (Iterator iterator = root.elementIterator() ; iterator.hasNext(); ) {
			Element e = (Element) iterator.next();
			System.out.println(e.attributeValue("age"));
		}
		System.out.println("----------------");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		org.w3c.dom.Document document2 = db.parse(new File("student2.xml"));
		DOMReader domReader = new DOMReader();
		Document d = domReader.read(document2);
		Element rootElement = d.getRootElement();
		System.out.println(rootElement.getName());
		
	}

}
