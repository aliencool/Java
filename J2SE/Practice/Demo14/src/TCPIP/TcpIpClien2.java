package TCPIP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

/*2013��10��16��20:27:29
 * ѧϰTCP/IPЭ���ʹ�� -�ͻ���
 * Ҫ�㣺���ڴ���������������뿪�ڴ���������
 * 
 * out��������,��ô������������ʹ��in���������ڴ�
 * 
 * */
public class TcpIpClien2 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
	
		Socket scoket=new  Socket("localhost",10002);
		
		//������������
		OutputStream out=scoket.getOutputStream();
	
		out.write("Hello world".getBytes());
	
		//���ܷ�������
		InputStream inputStream=scoket.getInputStream();
		byte[] bytes=new byte[1024];
		int len=inputStream.read(bytes);
		String str=new String(bytes,0,len);
		System.out.println(str);
		
		scoket.close();
		
	}

}
