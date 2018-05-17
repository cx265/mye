package com.cx.dom4j;

import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Test1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//创建文档并设置文档根节点，方法一
//		Document document = DocumentHelper.createDocument();
//		Element root = DocumentHelper.createElement("student");
//		document.setRootElement(root);
		//创建文档并设置文档根节点，方法二
		Element root = DocumentHelper.createElement("student");
		Document document = DocumentHelper.createDocument(root);
		root.addAttribute("name", "张三");
		Element helloElement = root.addElement("hello");
		Element worldElement = root.addElement("world");
		helloElement.setText("hello");
		worldElement.setText("world");
		helloElement.addAttribute("age","20");
		XMLWriter xmlWriter = new XMLWriter();
		xmlWriter.write(document);
		OutputFormat format = new OutputFormat("	",true);
		XMLWriter xmlWriter2 = new XMLWriter(new FileOutputStream("student.xml"),format);
		xmlWriter2.write(document);
		XMLWriter xmlWriter3 = new XMLWriter(new FileOutputStream("student2.xml"),format);
		xmlWriter3.write(document);
		xmlWriter3.flush();
		xmlWriter3.close();
	}


}
