package com.rabbit.designpattern.build;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.rabbit.designpattern.build.Product.CAR;
import com.rabbit.designpattern.build.Product.ProduceApi;

public class SimpleFactory3 {

	public static ProduceApi createApi(CAR type) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		Document document = null;
		String className = null;
		InputStream is = null;
		is = SimpleFactory3.class.getClassLoader().getResourceAsStream(
				"context.xml");

		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			document = db.parse(is);
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (is != null) {
				try {
					is.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		NodeList nodes = document.getElementsByTagName("bean");
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					if (element.getAttribute("name").equals(type.name())) {
						className = element.getAttribute("class");
					}
				}

			if (className != null) {
				break;
			}

		}
		if (className == null) {
			try {
				is.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new RuntimeException("can not find bean name");
		}
		try {
			return (ProduceApi) Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		throw new RuntimeException("can not find target class [" + className
				+ "]");

	}

	public static void main(String[] args) {
		ProduceApi api = createApi(CAR.BMW);
		api.produce("Hello Rabbit");
	}

}
