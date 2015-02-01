package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.CharBuffer;

/* 2013��10��14��21:43:17
 * 1:����һ��UPD�Ľ��շ���Scoket(ָ���˿ڣ���Ϊ�������Ƿ��͵�ָ���˿�)
 * 2:����һ�����ܰ�����Ϊ����Ҫ���ܰ�������ֻ�����ݰ������
 * 3:UPD��recevice�ӵ����ͷŵİ������������İ�
 * 4:�����İ�����
 * 5:�ر�
 * */
public class Recevise2 implements Runnable{
	private DatagramSocket dr;
	private DatagramPacket dp;
	
	public Recevise2(DatagramSocket dr) {
		super();
		this.dr = dr;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			byte[] buf=new byte[1024];
			dp=new DatagramPacket(buf, buf.length);
			
			try {
				dr.receive(dp);
				String ip=dp.getAddress().getHostAddress();//���͵�IP
				int port=dp.getPort();//���͵Ķ˿�
				String text = new String(dp.getData(), 0, dp.getLength());
				System.out.println(text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws SocketException {
		// TODO Auto-generated method stub
	
	}


}
