package TCPIP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*2013��10��16��22:56:13
 * ������������:
 * 1:�ͻ���û��ˢ�£����������������û�з��ͣ�
 * 2����Ϊ��û�л��У��������һֱ�Ȼ���!
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
		PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);//������ͻ���
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));//������������
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
