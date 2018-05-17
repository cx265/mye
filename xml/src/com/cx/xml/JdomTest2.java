package com.cx.xml;

import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JdomTest2 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws JDOMException 
	 */
	public static void main(String[] args) throws JDOMException, IOException {
		// TODO Auto-generated method stub
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(new File("jdom.xml"));
		Element element = doc.getRootElement();
		System.out.println(element.getName());
		Element hello = element.getChild("hello");
		System.out.println(hello.getText());
		List<Attribute> list = hello.getAttributes();
		for (int i = 0; i < list.size(); i++) {
			Attribute attr = (Attribute) list.get(i);
			String attrName = attr.getName();
			String attrValue = attr.getValue();
			System.out.println(attrName + "=" + attrValue);
		}
		hello.removeChild("world");
		//getRawFormat 去掉空白
		XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat().setIndent("	"));
		outputter.output(doc, new FileOutputStream("jdom2.xml"));
	}

}
