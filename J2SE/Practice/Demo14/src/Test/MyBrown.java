package Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyBrown {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
			Socket socket=new Socket("localhost",8090); //我要请求的服务器的地址
			
			PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
			pw.println("GET / HTTP/1.1");//我要使用的是get 方法 并且是Http 1.1版本
			pw.println("Accept: */*");//我能解析所有
			pw.println("Host: localhost:8090");//我要请求的服务器资源地址
			pw.println("Connection: colse");//请求所有
			pw.println();//换行 区分请求文
			
			int len=0;
			byte[] bs=new byte[1024];
			//得到服务器发来信息
			InputStream fileInputStream=socket.getInputStream();
			len=fileInputStream.read(bs);
			
			
			
			//打印得到服务器的信息
			String msg=new String(bs,0,len);
			System.out.println(msg);
			
			/*
 HTTP/1.1 200 OK  //响应头 响应的版本 状态 
Server: Apache-Coyote/1.1 //我解析你客户端的服务器是
Content-Type: text/html;charset=ISO-8859-1 //我的类型
Transfer-Encoding: chunked
Date: Tue, 22 Oct 2013 14:28:44 GMT //我的时间
			 * */
	}

}
