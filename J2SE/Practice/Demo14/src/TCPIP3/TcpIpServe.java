package TCPIP3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*2013��10��17��15:50:19
 * ������������:
 * 1:�ͻ��˷���ȥ�󣬷���˻���һֱ�ȴ���ȡ!
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
		BufferedWriter Writer=new BufferedWriter(new FileWriter("�½��ı��ĵ�2.txt"));
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));//������������
		String line=null;
		
		while((line=bufferedReader.readLine())!=null)
		{
			System.out.println(line);
			Writer.write(line);
			Writer.flush();
		}
		printWriter.write("�ϴ��ɹ�");
		
		printWriter.close();
		socket.close();
		serverSocket.close();
			
		
	}

}
