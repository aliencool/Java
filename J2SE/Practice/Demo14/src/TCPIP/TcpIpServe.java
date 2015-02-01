package TCPIP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*2013年10月16日20:27:29
 * 学习TCP/IP协议的使用 -服务器端
 * 注意:获取客户端来保证不会传错人,客户端传来的数据必须要输入到服务器端的内容，才能显示.或者输出到其他客户端
 * */
public class TcpIpServe {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//创建一个servesocket服务器，并说明那个应该程序解析
		ServerSocket serverSocket=new ServerSocket(10002);
		serverSocket.bind(endpoint)
		//获取客户端对象
		Socket socket=serverSocket.accept();
		//把客户端对象输入到服务器端内存
		InputStream inputStream=socket.getInputStream();
		//打印
		byte []by=new byte[1024];
		int len=inputStream.read(by);
		String str=new String(by,0,len);
		System.out.println(str);
		
		//关闭
		serverSocket.close();
		socket.close();
	}

}
