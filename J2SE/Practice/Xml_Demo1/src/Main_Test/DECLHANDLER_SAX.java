package Main_Test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.helpers.DefaultHandler;

public class DECLHANDLER_SAX extends DefaultHandler implements DeclHandler{
	
	
	/**
	 * @param eName :元素名称
	 * @param aName :属性名称
	 * @param mode  :模式
	 * @param value :固定的值
	 * **/
	@Override
	public void attributeDecl(String eName, String aName, String type,
			String mode, String value) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("元素名称为:"+eName+"属性名称为:"+aName+"类型为:"+mode+"固定值为:"+value);
	}
	/**
	 * @param name :元素名称
	 * @param model :元素值
	 * **/
	@Override
	public void elementDecl(String name, String model) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("元素名称为:"+name+model);
		
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
		System.out.println("元素为"+s);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("结束标记为:"+"<"+qName+">");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("开始标记为:"+"<"+qName+">");
	}
}
