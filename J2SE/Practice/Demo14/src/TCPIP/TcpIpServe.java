package TCPIP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*2013��10��16��20:27:29
 * ѧϰTCP/IPЭ���ʹ�� -��������
 * ע��:��ȡ�ͻ�������֤���ᴫ����,�ͻ��˴��������ݱ���Ҫ���뵽�������˵����ݣ�������ʾ.��������������ͻ���
 * */
public class TcpIpServe {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//����һ��servesocket����������˵���Ǹ�Ӧ�ó������
		ServerSocket serverSocket=new ServerSocket(10002);
		serverSocket.bind(endpoint)
		//��ȡ�ͻ��˶���
		Socket socket=serverSocket.accept();
		//�ѿͻ��˶������뵽���������ڴ�
		InputStream inputStream=socket.getInputStream();
		//��ӡ
		byte []by=new byte[1024];
		int len=inputStream.read(by);
		String str=new String(by,0,len);
		System.out.println(str);
		
		//�ر�
		serverSocket.close();
		socket.close();
	}

}
