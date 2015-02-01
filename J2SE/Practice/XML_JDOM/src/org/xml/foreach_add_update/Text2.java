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
/*2014年4月25日09:42:07
 * 错:
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
		//提取对象
		org.jdom.Document document=builder.build(new File("text.xml"));
		//获取根元素
		Element element=document.getRootElement();
		//递归调用根元素
		parse(element);
	}

	private static void parse(Element element) throws Exception {
		Element ele=new Element("学生");
		ele.setAttribute("年级","09");
		ele.setAttribute("学号","boo2");
		element.addContent(ele);
		//添加
		Element ele_name=new Element("姓名");
		ele_name.setText("李小一");
		Element ele_sex=new Element("性别");
		ele_sex.setText("女");
		Element ele_birth=new Element("生日");
		ele_birth.setText("1991-10-24");
		

		ele.addContent(ele_name);
		ele.addContent(ele_sex);
		ele.addContent(ele_birth);
		
		
		//转换输出
		//
		Format format=Format.getPrettyFormat();
		format.setEncoding("UTF-8");
		//
		XMLOutputter outputter=new XMLOutputter(format);
		//输出名称
		FileOutputStream fileOutputStream=new FileOutputStream("text_update.xml");
		//输出
		outputter.output(element, fileOutputStream);
		fileOutputStream.close();
		
		
	}
	
}
