package TCPIP3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
		BufferedReader bufferedReader=new BufferedReader(new FileReader("新建文本文档.txt"));
		BufferedReader bufferedReader2=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String msg=null;
		
		while((msg=bufferedReader.readLine())!=null)
		{
			
			
			printWriter.println(msg);//输出到服务器
		
		}
		socket.shutdownOutput();//发送结束标记
		msg=bufferedReader2.readLine();//等待上传成功反馈
		System.out.println(msg);
		
		socket.close();
	}

}
