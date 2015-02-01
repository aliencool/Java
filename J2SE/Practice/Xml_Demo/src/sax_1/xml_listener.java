package sax_1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class xml_listener extends DefaultHandler{
	private String Tag="";
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//��ӡ��Ԫ��
		System.out.println("Ԫ�ؿ�ʼ");
		
		String msg=new String(ch,start,length);
		//ȥ�ո���Ϊ��xml���������
		if(msg.trim().length()>0)
		{
			System.out.println("<"+Tag+">"+"Ԫ��:"+msg.trim());
		}
		
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		System.out.println("Ԫ�ش������"+qName);
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		System.out.println("<"+Tag+">ǰ׺:"+prefix);
		
	}
	
	@Override
	public void startDocument() throws SAXException {
		//ָ����ʼԪ��
		System.out.println("��ʼ����Ԫ��");
		
	}

	
	
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("localName:"+localName
				+"1111");
		System.out.println("��ʼ����Ԫ��"+qName);
		Tag=qName;
		//��ȡ����
		int len=attributes.getLength();
		
		if(len>0)
		{
			System.out.println("<"+Tag+">"+"��������:");
			for (int i = 0; i < len; i++) {
				System.out.println(attributes.getValue(i));
			}
			
		}
		
	}
	
	
    //�����ռ�
	@Override
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		//ǰ׺
		System.out.println("<+"+Tag+"+>ǰ׺:"+prefix);
		
		//URI
		System.out.println("<+"+Tag+"+>�ռ��ַ:"+uri);
	}
	

}
