package GuiOnlien3;
import java.net.*;
import java.util.HashMap;

public class Clienlistener {
	public static HashMap<String,Socket> hashmap=new HashMap<String, Socket>();
	
	//��Ҫ�����ĸ��ͻ���
	public static Socket Get(String key)
	{
		return hashmap.get(key);
	}
	
	//ÿ���ͻ���setһ��id
	public void Set(String key,Socket value)
	{
		hashmap.put(key, value);
	}
}
