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
		OutputStream out_up=socket.getOutputStream();//�����������
		InputStream up=new FileInputStream("1.JPG");//��ͣ����Ҫ�ϴ�ͼƬ����Ϣ
		BufferedReader bufferedReader2=new BufferedReader(new InputStreamReader(socket.getInputStream()));//��ȡ����˸����ҵ��ϴ��ɹ���Ϣ
		int Count=0;
		String msg=null;
		byte [] by=new byte[1024];
		
		while((Count=up.read(by))!=-1)
		{
			
			
			out_up.write(by,0,Count);//�����������
		
		}
		socket.shutdownOutput();//���ͽ�����ǣ����������˵�� �������
		msg=bufferedReader2.readLine();//�ȴ��ϴ��ɹ�����
		System.out.println(msg);
		
		socket.close();
	}

}
