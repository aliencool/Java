import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

/*2013��9��22��11:56:53
 * ѧϰJNDI:�������ֱ�Ӳ������ӵ����ݿ����ӡ�
 * */
public class MyfirstJNDI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String,Object> hash=new Hashtable<String,Object>();
		hash.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		hash.put(Context.PROVIDER_URL, "t3://172.16.142.209:7001");
		try
		{
			Context ctx=new InitialContext(hash);
			String str="First";
			ctx.rebind("myfirst", str);
			System.out.println("OK");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
