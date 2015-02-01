package Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyBrown {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
			Socket socket=new Socket("localhost",8090); //��Ҫ����ķ������ĵ�ַ
			
			PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
			pw.println("GET / HTTP/1.1");//��Ҫʹ�õ���get ���� ������Http 1.1�汾
			pw.println("Accept: */*");//���ܽ�������
			pw.println("Host: localhost:8090");//��Ҫ����ķ�������Դ��ַ
			pw.println("Connection: colse");//��������
			pw.println();//���� ����������
			
			int len=0;
			byte[] bs=new byte[1024];
			//�õ�������������Ϣ
			InputStream fileInputStream=socket.getInputStream();
			len=fileInputStream.read(bs);
			
			
			
			//��ӡ�õ�����������Ϣ
			String msg=new String(bs,0,len);
			System.out.println(msg);
			
			/*
 HTTP/1.1 200 OK  //��Ӧͷ ��Ӧ�İ汾 ״̬ 
Server: Apache-Coyote/1.1 //�ҽ�����ͻ��˵ķ�������
Content-Type: text/html;charset=ISO-8859-1 //�ҵ�����
Transfer-Encoding: chunked
Date: Tue, 22 Oct 2013 14:28:44 GMT //�ҵ�ʱ��
			 * */
	}

}
