package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/*2013��10��14��21:37:19
 * ����UPD�ķ��ͷ�
 * 1:����UPD��SOCKET
 * 2:�������͵�UDP�İ�
 * 3:ͨ��UPD��SOCKET����
 * 4:�ر�
 * */
public class SendTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//����UPD��Socket
		DatagramSocket ds=new DatagramSocket();
		
		//�������͵�UDP��
		String msg="���ã����磬�ҵĵ�һ��UDP";
		byte [] b=msg.getBytes();
		DatagramPacket dp=new DatagramPacket(b, b.length,InetAddress.getByName("localhost"),10000);
		
		//����
		ds.send(dp);
		
		//�ر�
		ds.close();
	}

}
