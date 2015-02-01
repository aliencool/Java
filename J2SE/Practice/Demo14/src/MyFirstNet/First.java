/*2013年10月14日20:35:15
 * 
 * */


package MyFirstNet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class First {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		
		//得到本地
		InetAddress ip=InetAddress.getLocalHost();
		System.out.println(ip.getHostAddress());
		System.out.println(ip.getHostName());
		
		//得到外面
		ip=InetAddress.getByName("www.baidu.com");
		System.out.println(ip.getHostAddress());
		System.out.println(ip.getHostName());
	}

}
