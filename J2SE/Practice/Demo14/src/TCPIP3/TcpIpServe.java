package TCPIP3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
		Socket socket=serverSocket.accept();
		PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
		BufferedWriter Writer=new BufferedWriter(new FileWriter("新建文本文档2.txt"));
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));//读进到服务器
		String line=null;
		
		while((line=bufferedReader.readLine())!=null)
		{
			System.out.println(line);
			Writer.write(line);
			Writer.flush();
		}
		printWriter.write("上传成功");
		
		printWriter.close();
		socket.close();
		serverSocket.close();
			
		
	}

}
