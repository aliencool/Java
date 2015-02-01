package Foreach;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*2014年4月18日09:11:23
 * DOM FOREACH XML
 * */
public class XML_F {
	
	public static void main(String[] args) throws Exception
	{
		//execute
		foreach();
	}
	private static Document GetDoc() throws ParserConfigurationException,
	SAXException, IOException {
		//create factory
		DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		//create build
		DocumentBuilder builder=builderFactory.newDocumentBuilder();


		//create document
		Document document=builder.parse(new File("test.xml"));
		return document;
	}
	
	public static void foreach() throws Exception
	{
		Document document = GetDoc();
		
		//accept element
		Element element=document.getDocumentElement();
		//accept nodelist
		NodeList nodeList=element.getChildNodes();
	
		//foreach
		for (int i = 0; i < nodeList.getLength(); i++) {
			//accept node
			//node have attribute and element and content
			Node node=nodeList.item(i);
			System.out.println(node.getNodeName()+" is "+node.getTextContent());
		}
	}
	
	public static void add() throws Exception
	{
		Document document = GetDoc();
		//accept Root
		Element element_root=document.getDocumentElement();
		
	
		
		//add felement
		Element element_fchild=document.createElement("team_memo");
		
		
		//add selement
		
		Element element_schild=document.createElement("name");
		element_schild.setAttribute("value", "ttttt");
		element_fchild.appendChild(element_schild);
		
		element_schild=document.createElement("empno");
		element_schild.setAttribute("value", "30886");
		element_fchild.appendChild(element_schild);

		element_schild=document.createElement("designation");
		element_schild.setAttribute("value", "Team leader");
		element_fchild.appendChild(element_schild);
		
		element_schild=document.createElement("email");
		element_schild.setAttribute("value", "www@qqq.con");
		element_fchild.appendChild(element_schild);
		
		
		
		element_root.appendChild(element_fchild);		
		
		//利用文档节点创建一个DOM输入源 
        DOMSource source=new DOMSource(document); 
        //以converted.xml文件构造一个StreamResult对象，用于保存转换后结果。 
        StreamResult result=new StreamResult(new File("converted.xml")); 
        
        //得到转换器工厂类的实例 
        TransformerFactory tff = TransformerFactory.newInstance(); 
        //创建一个新的转换器，用于执行恒等转换， 
        //即直接将DOM输入源的内容复制到结果文档中。 
        Transformer tf = tff.newTransformer(); 
        //执行转换 
        tf.transform(source, result); 
		
		
	}

	
	
}
