package testjndi;

import java.util.*;
import javax.naming.*;

public class testBind {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Hashtable<String,Object> ht=new Hashtable<String,Object>();//泛型定义，提高程序复用性。
		  ht.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		   ht.put(Context.PROVIDER_URL,"t3://localhost:7001");
		   try
		   {
			   InitialContext ctx=new InitialContext(ht);
			   String str="Hello world";
			   ctx.bind("myfirst", str);
			   System.out.println("object Bound!");
		   }
		   catch(Exception e)
		   {
			  
			   e.printStackTrace();
		   }
	}

}
