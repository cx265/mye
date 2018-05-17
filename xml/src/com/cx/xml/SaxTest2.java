package com.cx.xml;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxTest2 {

	/**
	 * @param args
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser parser = spf.newSAXParser();
		parser.parse(new File("cx.xml"), new MyHandler2());
	}

}

class MyHandler2 extends DefaultHandler{
	
	private Stack<String> stack = new Stack<String>();
	private String name;
	private String age;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		stack.push(qName);
		for (int i = 0; i < attributes.getLength(); i++) {
			String attrName = attributes.getQName(i);
			String attrAge = attributes.getValue(i);
			System.out.println(attrName + "=" + attrAge);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		String tag = stack.peek();
		if ("name".equals(tag)) {
			name = new String(ch,start,length);
		}else if ("age".equals(tag)) {
			age = new String(ch,start,length);
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		stack.pop();
		if ("stu".equals(qName)) {
			System.out.println("name:" + name);
			System.out.println("age:" + age);
		}
	}
	
	
}
