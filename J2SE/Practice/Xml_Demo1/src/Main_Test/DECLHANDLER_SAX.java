package Main_Test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.helpers.DefaultHandler;

public class DECLHANDLER_SAX extends DefaultHandler implements DeclHandler{
	
	
	/**
	 * @param eName :Ԫ������
	 * @param aName :��������
	 * @param mode  :ģʽ
	 * @param value :�̶���ֵ
	 * **/
	@Override
	public void attributeDecl(String eName, String aName, String type,
			String mode, String value) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Ԫ������Ϊ:"+eName+"��������Ϊ:"+aName+"����Ϊ:"+mode+"�̶�ֵΪ:"+value);
	}
	/**
	 * @param name :Ԫ������
	 * @param model :Ԫ��ֵ
	 * **/
	@Override
	public void elementDecl(String name, String model) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Ԫ������Ϊ:"+name+model);
		
	}

	@Override
	public void externalEntityDecl(String name, String publicId, String systemId)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalEntityDecl(String name, String value)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		String s=new String(ch,start,length);
		s.trim();
		System.out.println("Ԫ��Ϊ"+s);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("�������Ϊ:"+"<"+qName+">");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("��ʼ���Ϊ:"+"<"+qName+">");
	}
}
