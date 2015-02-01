package org.xml.foreach_add_update;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.w3c.dom.Document;
import org.jdom.*;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
/*2014��4��25��09:42:07
 * ��:
 * 1:set
 * 2:XMLOutputter(format) (ele,out)
 * */
public class Text2 {
	public static void main(String[] args) throws Exception
	{
		foreach();
	}
	
	public static void foreach() throws Exception
	{
		//sax
		SAXBuilder builder=new SAXBuilder();
		//��ȡ����
		org.jdom.Document document=builder.build(new File("text.xml"));
		//��ȡ��Ԫ��
		Element element=document.getRootElement();
		//�ݹ���ø�Ԫ��
		parse(element);
	}

	private static void parse(Element element) throws Exception {
		Element ele=new Element("ѧ��");
		ele.setAttribute("�꼶","09");
		ele.setAttribute("ѧ��","boo2");
		element.addContent(ele);
		//���
		Element ele_name=new Element("����");
		ele_name.setText("��Сһ");
		Element ele_sex=new Element("�Ա�");
		ele_sex.setText("Ů");
		Element ele_birth=new Element("����");
		ele_birth.setText("1991-10-24");
		

		ele.addContent(ele_name);
		ele.addContent(ele_sex);
		ele.addContent(ele_birth);
		
		
		//ת�����
		//
		Format format=Format.getPrettyFormat();
		format.setEncoding("UTF-8");
		//
		XMLOutputter outputter=new XMLOutputter(format);
		//�������
		FileOutputStream fileOutputStream=new FileOutputStream("text_update.xml");
		//���
		outputter.output(element, fileOutputStream);
		fileOutputStream.close();
		
		
	}
	
}
