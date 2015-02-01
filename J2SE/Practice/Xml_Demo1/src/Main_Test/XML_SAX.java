package Main_Test;

import java.net.ContentHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XML_SAX {
		public static void  main(String args[])
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			try {
				SAXParser parser=factory.newSAXParser();
				
				//Ìí¼Óxml
				parser.parse("Teams.xml",new DECLHANDLER_SAX());
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
}
