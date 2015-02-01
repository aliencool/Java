package testjndi;
import javax.naming.*;
import java.util.Properties;
import java.io.*;

public class testLookup_Property {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Lookup Begin...");
		  try{
			  Properties props=new Properties();
			  props.load(new FileInputStream("jndiprovider.properties"));
			 InitialContext ctx = new InitialContext(props);
			    String result;
			    result=(String)ctx.lookup("myfirst");
			    System.out.println("result is:"+result);
			    System.out.println("lookup end!");	    
		  }catch(Exception e){e.printStackTrace();}
		  
		  }


	}

