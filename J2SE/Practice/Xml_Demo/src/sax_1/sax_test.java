package sax_1;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
/*2014��3��15��23:24:10
 * ʵ��ָ����:
 *  1 class ���� 
 *  2 SAXParserFactory ����ʵ����factory
 * */
public class sax_test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����������
		SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
		//��������
		try {
			SAXParser parser=saxParserFactory.newSAXParser();
			parser.parse("2_1.xml", new xml_listener());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

}
