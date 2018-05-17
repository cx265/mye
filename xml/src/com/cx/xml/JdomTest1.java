package com.cx.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.Comment;

public class JdomTest1 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Document document = new Document();
		Element root = new Element("root");
		document.addContent(root);
		Comment comment = new org.jdom2.Comment("a comment");
		root.addContent(comment);
		Element e = new Element("hello");
		e.setAttribute("sohu","www.sohu.com");
		root.addContent(e);
		Element e2 = new Element("world");
		Attribute attr = new Attribute("test", "hehe");
		e2.setAttribute(attr);
		e.addContent(e2);
		e.addContent(new Element("cx").setAttribute("zzz","1111").setAttribute("xxx","2222").setAttribute("ccc","33333"));
		Format format = Format.getPrettyFormat();
		format.setIndent("	");
		format.setEncoding("UTF-8");
		XMLOutputter out = new XMLOutputter(format);
		out.output(document, new FileOutputStream("jdom.xml"));
		
	}

}
