package myjndi;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



public class SingleTest {
	private static SingleTest single;
	private static Context ctx;
	
	private SingleTest() throws NamingException{
		ctx=Tool.getIntanceofContext();
	}
	
	public static SingleTest getInstanceof() throws NamingException
	{
		if(single==null)
		{
			single=new SingleTest();
		}
		return single;
		
	}
	
	public Object lookup(String name) throws NamingException
	{
		Object ob=new Object();
		ob=(Object)ctx.lookup(name);
		return ob;
	}

}


class Tool
{
	public static Context getIntanceofContext() throws NamingException
	{
		
		Hashtable<String,Object> hash=new Hashtable<String, Object>();
		hash.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		hash.put(Context.PROVIDER_URL, "t3://localhost:7001");
		return new InitialContext(hash);
		
	
	}

	
	
}
