package com.cx.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTest2 {

	/**
	 * @param args
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new File("cx.xml"));
		Element root = doc.getDocumentElement();
		parseElement(root);
	}

	private static void parseElement(Element element) {
		// TODO Auto-generated method stub
		String tagNameString = element.getNodeName();
		NodeList children = element.getChildNodes();
		System.out.print("<" + tagNameString);
		NamedNodeMap map = element.getAttributes();
		if (null != map) {
			for (int i = 0; i < map.getLength(); i++) {
				Attr attr = (Attr)map.item(i);
				String attrNameString = attr.getName();
				String attrValueString = attr.getValue();
				System.out.print(" " + attrNameString +"=\"" + attrValueString +"\"");
			}
		}
		System.out.print(">");
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			short nodeType = node.getNodeType();
			if (nodeType == Node.ELEMENT_NODE) {
				parseElement((Element)node);
			}else if (nodeType == Node.TEXT_NODE) {
				System.out.print(node.getNodeValue());
			}else if (nodeType == Node.COMMENT_NODE) {
				System.out.print("<!--");
				Comment comment = (Comment) node;
				String dataString = comment.getData();
				System.out.print(dataString);
				System.out.print("-->");
			}
		}
		System.out.print("</" + tagNameString + ">");
	}

}
