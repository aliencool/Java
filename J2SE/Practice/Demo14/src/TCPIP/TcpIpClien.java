package TCPIP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;

/*2013��10��16��20:27:29
 * ѧϰTCP/IPЭ���ʹ�� -�ͻ���
 * Ҫ�㣺���ڴ���������������뿪�ڴ���������
 * */
public class TcpIpClien {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		//��һ��������SOCKET�Ŀͻ�����˵�
		Socket scoket=new  Socket("localhost",10002);
		//�ڶ�������ȡͨ����
		OutputStream out=scoket.getOutputStream();
		//��������д������
		out.write("Hello world".getBytes());
		//���Ĳ����ر���
		scoket.close();
		
	}

}
