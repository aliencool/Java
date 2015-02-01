package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class Send2 implements Runnable{
	private DatagramSocket ds;
	private byte[] buf;
	public Send2(DatagramSocket ds,byte[] buf) {
		super();
		this.ds = ds;
		this.buf=buf;
	
	}

	public void run() {
			
				
		try {
			while(true)
			if(buf.length!=0){

				DatagramPacket dp = 
						new DatagramPacket(buf,buf.length,InetAddress.getByName("localhost"),10001);
				ds.send(dp);
		
			}
			
		} catch (Exception e) {
		}
		finally
		{
			if(ds!=null)
			{
				ds.close();
			}
		}
	}



}
