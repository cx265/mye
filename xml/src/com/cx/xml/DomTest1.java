package com.cx.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTest1 {

	/**
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		// TODO Auto-generated method stub
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(new File("cx.xml"));
		NodeList list = document.getElementsByTagName("stu");
		System.out.println(list.getLength());
		String name = null;
		for (int i = 0; i < list.getLength(); i++) {
			Element element = (Element) list.item(i);
//			name = element.getElementsByTagName("name").item(0).getFirstChild()
//					.getNodeValue();
//			System.out.println(name);
//			name = element.getElementsByTagName("age").item(0).getFirstChild()
//					.getNodeValue();
//			System.out.println(name);
			System.out.println(element.getTextContent());
			System.out.println("------------");
		}
		
		for (int i = 0; i < list.getLength(); i++) {
			NamedNodeMap nnm = list.item(i).getAttributes();
			String attrName = nnm.item(0).getNodeName();
			String attrValue = nnm.item(0).getNodeValue();
			System.out.println(attrName + "=" + attrValue);
			
		}
	}

}
