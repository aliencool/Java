package TCPIP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*2013��10��16��20:27:29
 * ѧϰTCP/IPЭ���ʹ�� -��������
 * ע��:��ȡ�ͻ�������֤���ᴫ����,�ͻ��˴��������ݱ���Ҫ���뵽�������˵����ݣ�������ʾ.��������������ͻ���
 * 
 * 
 * out���ͻ���,����ʹ��in���ͻ����ڴ�
 * */
public class TcpIpServe2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ServerSocket serverSocket=new ServerSocket(10002);

		Socket socket=serverSocket.accept();
		
		InputStream inputStream=socket.getInputStream();
		
		//�ӵ��ͻ��˵�
		byte []by=new byte[1024];
		int len=inputStream.read(by);
		String str=new String(by,0,len);
		System.out.println(str);
		
		//���͵��ͻ��˵�
		OutputStream outputStream=socket.getOutputStream();
		outputStream.write("Accpet...".getBytes());
		
		//�ر�
		serverSocket.close();
		socket.close();
	}

}
