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
		while(true)//ÿ�����ӽ��������µ��û�
		{
			Socket socket=serverSocket.accept();
			new Thread(new Upload(socket)).start();//ÿ���µ��̶߳�����
		}
		
			
		
	}

}
