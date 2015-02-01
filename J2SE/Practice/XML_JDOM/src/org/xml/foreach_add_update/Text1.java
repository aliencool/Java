package org.xml.foreach_add_update;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.w3c.dom.Document;
import org.jdom.*;
import org.jdom.input.SAXBuilder;
/*2014年4月25日09:42:07
 * 错:
 * 1:sax
 * 2:getrootname
 * 3:子元素
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
		//提取对象
		org.jdom.Document document=builder.build(new File("text_update.xml"));
		//获取根元素
		Element element=document.getRootElement();
		
		System.out.println("命名空间:"+element.getNamespaceURI()+"前缀:"+element.getNamespacePrefix());
		//递归调用根元素
		parse(element);
	}

	private static void parse(Element element) {
		//得到属性
		get_attribute(element);
		
		//得到所有子元素
		List<Element> list=element.getChildren();
		
		for(Element el:list)
		{
			//如果，还有子元素递归
			if(el.getChildren().size()>0)
			{
				parse(el);
			}
			else  //没有的话直接打印
 			{	
				get_attribute(el);
				
				System.out.println(el.getName()+"的值为:"+el.getText());
			}
		}
		
		
	}
	private static void get_attribute(Element element)
	{
		List<Attribute> attribute=element.getAttributes();
		for(Attribute atr_name:attribute)
		{
			System.out.println(element.getName()+"属性有:"+atr_name.getName()+":"+atr_name.getValue());
		}
		
	}
	
}
