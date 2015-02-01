package GuiOnlien3;
import java.net.*;
import java.util.HashMap;

public class Clienlistener {
	public static HashMap<String,Socket> hashmap=new HashMap<String, Socket>();
	
	//你要发送哪个客户端
	public static Socket Get(String key)
	{
		return hashmap.get(key);
	}
	
	//每个客户端set一个id
	public void Set(String key,Socket value)
	{
		hashmap.put(key, value);
	}
}
