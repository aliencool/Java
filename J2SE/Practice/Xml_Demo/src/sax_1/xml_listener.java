package sax_1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class xml_listener extends DefaultHandler{
	private String Tag="";
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//打印出元素
		System.out.println("元素开始");
		
		String msg=new String(ch,start,length);
		//去空格！因为，xml会把它读入
		if(msg.trim().length()>0)
		{
			System.out.println("<"+Tag+">"+"元素:"+msg.trim());
		}
		
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		System.out.println("元素处理结束"+qName);
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		System.out.println("<"+Tag+">前缀:"+prefix);
		
	}
	
	@Override
	public void startDocument() throws SAXException {
		//指明开始元素
		System.out.println("开始处理元素");
		
	}

	
	
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("localName:"+localName
				+"1111");
		System.out.println("开始处理元素"+qName);
		Tag=qName;
		//获取属性
		int len=attributes.getLength();
		
		if(len>0)
		{
			System.out.println("<"+Tag+">"+"属性如下:");
			for (int i = 0; i < len; i++) {
				System.out.println(attributes.getValue(i));
			}
			
		}
		
	}
	
	
    //命名空间
	@Override
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		//前缀
		System.out.println("<+"+Tag+"+>前缀:"+prefix);
		
		//URI
		System.out.println("<+"+Tag+"+>空间地址:"+uri);
	}
	

}
