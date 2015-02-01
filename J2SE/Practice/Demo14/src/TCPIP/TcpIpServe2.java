package TCPIP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*2013年10月16日20:27:29
 * 学习TCP/IP协议的使用 -服务器端
 * 注意:获取客户端来保证不会传错人,客户端传来的数据必须要输入到服务器端的内容，才能显示.或者输出到其他客户端
 * 
 * 
 * out到客户端,必须使用in到客户端内存
 * */
public class TcpIpServe2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ServerSocket serverSocket=new ServerSocket(10002);

		Socket socket=serverSocket.accept();
		
		InputStream inputStream=socket.getInputStream();
		
		//接到客户端的
		byte []by=new byte[1024];
		int len=inputStream.read(by);
		String str=new String(by,0,len);
		System.out.println(str);
		
		//发送到客户端的
		OutputStream outputStream=socket.getOutputStream();
		outputStream.write("Accpet...".getBytes());
		
		//关闭
		serverSocket.close();
		socket.close();
	}

}
