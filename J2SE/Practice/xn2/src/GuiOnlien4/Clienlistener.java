package GuiOnlien4;
import java.net.*;
import java.util.HashMap;
import java.util.Iterator;

public class Clienlistener {
	public static  HashMap<String,Socket> hashmap=new HashMap<String, Socket>();
	
	//��Ҫ�����ĸ��ͻ���
	public static  Socket Get(String key)
	{
		return hashmap.get(key);
	}
	
	//ÿ���ͻ���setһ��id
	public static  void Set(String key,Socket value)
	{
		hashmap.put(key, value);
	}
	
}
