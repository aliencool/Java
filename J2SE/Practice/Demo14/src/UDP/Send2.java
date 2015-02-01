package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/*2013年10月14日21:37:19
 * 基于UPD的发送放
 * 1:创建UPD的SOCKET
 * 2:创建发送的UDP的包
 * 3:通过UPD的SOCKET传送
 * 4:关闭
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
