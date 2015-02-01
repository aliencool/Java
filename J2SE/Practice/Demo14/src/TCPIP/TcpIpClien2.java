package TCPIP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

/*2013年10月16日20:27:29
 * 学习TCP/IP协议的使用 -客户端
 * 要点：从内存输出到服务器（离开内存就是输出）
 * 
 * out到服务器,那么，服务器必须使用in到服务器内存
 * 
 * */
public class TcpIpClien2 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
	
		Socket scoket=new  Socket("localhost",10002);
		
		//发到服务器的
		OutputStream out=scoket.getOutputStream();
	
		out.write("Hello world".getBytes());
	
		//接受服务器的
		InputStream inputStream=scoket.getInputStream();
		byte[] bytes=new byte[1024];
		int len=inputStream.read(bytes);
		String str=new String(bytes,0,len);
		System.out.println(str);
		
		scoket.close();
		
	}

}
