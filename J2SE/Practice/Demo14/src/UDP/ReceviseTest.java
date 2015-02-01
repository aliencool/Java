package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/* 2013��10��14��21:43:17
 * 1:����һ��UPD�Ľ��շ���Scoket(ָ���˿ڣ���Ϊ�������Ƿ��͵�ָ���˿�)
 * 2:����һ�����ܰ�����Ϊ����Ҫ���ܰ�������ֻ�����ݰ������
 * 3:UPD��recevice�ӵ����ͷŵİ������������İ�
 * 4:�����İ�����
 * 5:�ر�
 * */
public class ReceviseTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//1 ����һ��UPD�Ľ��շ���Scoket
		DatagramSocket ds=new DatagramSocket(10000);
		
		//2 ����һ�������������Ͷ�
		byte []buf=new byte[1024];
		DatagramPacket dp=new DatagramPacket(buf, buf.length);
		//3 ���ܰ����������İ�
		ds.receive(dp);//����
		//����
		String ip=dp.getAddress().getHostAddress();//���͵�IP
		int port=dp.getPort();//���͵Ķ˿�
		String text=new String(dp.getData(),0,dp.getData().length);
		System.out.println("Ip:"+ip+"�˿�:"+port+"���ͷ�����Ϣ:"+text);
		//�ر�
		ds.close();
	}

}
