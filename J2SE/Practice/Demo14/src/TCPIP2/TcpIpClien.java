package TCPIP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

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
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader bufferedIn=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String msg=null;
		
		while((msg=bufferedReader.readLine())!=null)
		{
			
			if("over".equals(msg))
				break;
			
			printWriter.println(msg);//输出到服务器
			
			String upperStr = bufferedIn.readLine();//接受服务器的
			System.out.println(upperStr);
			
		
		}
		
		socket.close();
	}

}
