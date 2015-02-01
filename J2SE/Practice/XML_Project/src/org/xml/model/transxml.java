package org.xml.model;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.bean.Data_Bean;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class transxml {
	public static  void trans(Data_Bean dataBean,String Table_name,String Data_Name,String path)
	{
		Document document=new Document();
		Element root=new Element(Table_name);
		document.addContent(root);
		//set±éÀú¼¯ºÏ
		Set<Map.Entry<String, String>> map_set=dataBean.getColumn_name().entrySet();
		Iterator<Map.Entry<String, String>> it=map_set.iterator();
		while(it.hasNext())
		{
			Map.Entry<String, String> entry=it.next();
			
			Element child=new Element(entry.getKey());
			child.setText(entry.getValue());
			root.addContent(child);
		}
		Format format=Format.getPrettyFormat();
		format.setEncoding("UTF-8");
		XMLOutputter outputter=new XMLOutputter(format);
		try {
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHMMs");
			String time=dateFormat.format(new Date());
			
			
			FileOutputStream fileOutputStream=new FileOutputStream(path+"//"+Data_Name+Table_name+time+".xml");
			outputter.output(root, fileOutputStream);
			fileOutputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
