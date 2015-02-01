package sax_1;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
/*2014年3月15日23:24:10
 * 实验指导了:
 *  1 class 区别 
 *  2 SAXParserFactory 再用实例的factory
 * */
public class sax_test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建工厂类
		SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
		//创建监听
		try {
			SAXParser parser=saxParserFactory.newSAXParser();
			parser.parse("2_1.xml", new xml_listener());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

}
