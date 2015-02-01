
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;


public class MyfirstLookup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String,Object> hash=new Hashtable<String,Object>();
		hash.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		hash.put(Context.PROVIDER_URL, "t3://localhost:7001");
		try
		{
			Context ctx=new InitialContext(hash);
			String str=(String)ctx.lookup("myfirst");
			System.out.println("Found:"+str);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
