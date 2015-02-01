package TCPIP4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import TCPIP4.Upload;

/*2013年10月17日15:50:19
 * 出现阻塞问题:
 * 1:客户端发过去后，服务端还在一直等待读取!
 * */
public class TcpIpServe {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket serverSocket=new ServerSocket(10004);
		while(true)//每次连接进来都是新的用户
		{
			Socket socket=serverSocket.accept();
			new Thread(new Upload(socket)).start();//每个新的线程都创建
		}
		
			
		
	}

}
