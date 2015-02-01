package Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class MyTomCat {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			ServerSocket serverSocket=new ServerSocket(8090);
			Socket socket=serverSocket.accept();
			
			int len=0;
			byte[] bs=new byte[1024];
			//得到客户端发来信息
			InputStream fileInputStream=socket.getInputStream();
			len=fileInputStream.read(bs);
			
			//打印得到客户端的信息
			String msg=new String(bs,0,len);
			System.out.println(msg);
			/*
			 *  GET / HTTP/1.1 请求行 get 方法 /的资源 HTTP所有资源
				//请求消息包头
				Accept: image/jpeg, application/x-ms-application, image/gif, application/xaml+xml, image/pjpeg, application/x-ms-xbap 客户端解析的方式
				Accept-Language: zh-CN 请求的名字  
				User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET4.0C; .NET4.0E)
				Accept-Encoding: gzip, deflate  我客户端可以解压的格式
				Host: localhost:8090 我请求你的资源是在
				Connection: Keep-Alive
			 * */
			
			/*返回给客户端
			 * */
			PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
			printWriter.println("欢迎光临 您访问是我的服务器!");
			printWriter.println("谢谢");
			printWriter.close();
			socket.close();
			
			
	}

}
