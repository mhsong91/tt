package tt;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {
	public static Map<String, Object> beanFactory = new HashMap<String,Object>();
	
	public static Object newInstance(String cn) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class c = Class.forName(cn);
		return c.newInstance();
	}
	public static void main(String[] args) {
		InputStream inputStream = null;
		try {
			inputStream = XMLParser.class.getResourceAsStream("beans.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(inputStream);
			document.getDocumentElement().normalize();
			
			NodeList nl = document.getElementsByTagName("bean");
			for(int i=0;i<nl.getLength();i++) {
				Node n = nl.item(i);
				Element e = (Element)n;
				System.out.println(e.getAttribute("id"));
				System.out.println(e.getAttribute("class"));
				String key = e.getAttribute("id");
				String cn = e.getAttribute("class");
				beanFactory.put(key, newInstance(cn));
			}
			HelloWorld1 hw1 = (HelloWorld1)beanFactory.get("hw1");
			hw1.printSome("내가 찍히지!!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
