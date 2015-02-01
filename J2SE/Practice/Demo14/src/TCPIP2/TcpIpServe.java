package TCPIP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*2013年10月16日22:56:13
 * 出现阻塞问题:
 * 1:客户端没有刷新，则服务器端阻塞（没有发送）
 * 2：因为，没有换行，则服务器一直等换行!
 * */
public class TcpIpServe {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket serverSocket=new ServerSocket(10004);
		Socket socket=serverSocket.accept();
		PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);//输出到客户端
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));//读进到服务器
		String line=null;
		
		while((line=bufferedReader.readLine())!=null)
		{
			System.out.println(socket.getInetAddress().getHostAddress()+":"+line);
			pw.println(line.toUpperCase());
		}
		socket.close();
		serverSocket.close();
			
		
	}

}
