package Test;
/*2013年10月23日21:40:21
 *URL openStream==URL openConnection+socket==解析协议和socket
 *openConnection:还可以获取请求头
 * */
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URL_Demo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			String str="http://localhost:8090";
			
			URL url=new URL(str);//解析str
			
			int len=0;
			byte[] bs=new byte[1024];
			//得到服务器发来信息
			//InputStream fileInputStream=url.openStream(); 第一种//解析InputStream
			//第二种
			URLConnection msg1=url.openConnection();
			System.out.println(msg1.getHeaderField("Server"));
		
	}

}
