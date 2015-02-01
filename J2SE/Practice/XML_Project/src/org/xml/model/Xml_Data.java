package org.xml.model;

import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.bean.Data_Bean;

public class Xml_Data {
	private static String [] values;
	//计数器
	private static int i=0;
	//保存
	private static int len=0;
	
	public  static void explain_xml(String path) throws Exception
	{
		SAXBuilder builder=new SAXBuilder();
		
		Document document=builder.build(path);
		
		Element element=document.getRootElement();
		
		parse(element);
		
		Dao_Implement implem=new Dao_Implement();
		
		//插入
		implem.Insert(values);
	}

	private static void parse(Element element) {
		//每次都删除父节点
		List<Element> ele=element.getChildren();
		//第一次保存
			values=new String[ele.size()];
		for(Element e:ele)
		{
				values[i]=e.getValue();
				i++;
		}
		
	}
}
