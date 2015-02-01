package Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class MyTomCat {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			ServerSocket serverSocket=new ServerSocket(8090);
			Socket socket=serverSocket.accept();
			
			int len=0;
			byte[] bs=new byte[1024];
			//�õ��ͻ��˷�����Ϣ
			InputStream fileInputStream=socket.getInputStream();
			len=fileInputStream.read(bs);
			
			//��ӡ�õ��ͻ��˵���Ϣ
			String msg=new String(bs,0,len);
			System.out.println(msg);
			/*
			 *  GET / HTTP/1.1 ������ get ���� /����Դ HTTP������Դ
				//������Ϣ��ͷ
				Accept: image/jpeg, application/x-ms-application, image/gif, application/xaml+xml, image/pjpeg, application/x-ms-xbap �ͻ��˽����ķ�ʽ
				Accept-Language: zh-CN ���������  
				User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET4.0C; .NET4.0E)
				Accept-Encoding: gzip, deflate  �ҿͻ��˿��Խ�ѹ�ĸ�ʽ
				Host: localhost:8090 �����������Դ����
				Connection: Keep-Alive
			 * */
			
			/*���ظ��ͻ���
			 * */
			PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
			printWriter.println("��ӭ���� ���������ҵķ�����!");
			printWriter.println("лл");
			printWriter.close();
			socket.close();
			
			
	}

}
