package TCPIP4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;

public class TcpIpClien {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket socket=new Socket("localhost",10004); 
		OutputStream out_up=socket.getOutputStream();//输出到服务器
		InputStream up=new FileInputStream("1.JPG");//不停读我要上传图片的信息
		BufferedReader bufferedReader2=new BufferedReader(new InputStreamReader(socket.getInputStream()));//读取服务端告诉我的上传成功信息
		int Count=0;
		String msg=null;
		byte [] by=new byte[1024];
		
		while((Count=up.read(by))!=-1)
		{
			
			
			out_up.write(by,0,Count);//输出到服务器
		
		}
		socket.shutdownOutput();//发送结束标记，即向服务器说明 发送完毕
		msg=bufferedReader2.readLine();//等待上传成功反馈
		System.out.println(msg);
		
		socket.close();
	}

}
