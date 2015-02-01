package org.xml.foreach_add_update;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.w3c.dom.Document;
import org.jdom.*;
import org.jdom.input.SAXBuilder;
/*2014��4��25��09:42:07
 * ��:
 * 1:sax
 * 2:getrootname
 * 3:��Ԫ��
 * */
public class Text1 {
	public static void main(String[] args) throws Exception
	{
		foreach();
	}
	
	public static void foreach() throws Exception
	{
		//sax
		SAXBuilder builder=new SAXBuilder();
		//��ȡ����
		org.jdom.Document document=builder.build(new File("text_update.xml"));
		//��ȡ��Ԫ��
		Element element=document.getRootElement();
		
		System.out.println("�����ռ�:"+element.getNamespaceURI()+"ǰ׺:"+element.getNamespacePrefix());
		//�ݹ���ø�Ԫ��
		parse(element);
	}

	private static void parse(Element element) {
		//�õ�����
		get_attribute(element);
		
		//�õ�������Ԫ��
		List<Element> list=element.getChildren();
		
		for(Element el:list)
		{
			//�����������Ԫ�صݹ�
			if(el.getChildren().size()>0)
			{
				parse(el);
			}
			else  //û�еĻ�ֱ�Ӵ�ӡ
 			{	
				get_attribute(el);
				
				System.out.println(el.getName()+"��ֵΪ:"+el.getText());
			}
		}
		
		
	}
	private static void get_attribute(Element element)
	{
		List<Attribute> attribute=element.getAttributes();
		for(Attribute atr_name:attribute)
		{
			System.out.println(element.getName()+"������:"+atr_name.getName()+":"+atr_name.getValue());
		}
		
	}
	
}
