package TCPIP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;

/*2013年10月16日20:27:29
 * 学习TCP/IP协议的使用 -客户端
 * 要点：从内存输出到服务器（离开内存就是输出）
 * */
public class TcpIpClien {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		//第一步：创建SOCKET的客户服务端点
		Socket scoket=new  Socket("localhost",10002);
		//第二步：获取通道流
		OutputStream out=scoket.getOutputStream();
		//第三步：写进数据
		out.write("Hello world".getBytes());
		//第四步：关闭流
		scoket.close();
		
	}

}
