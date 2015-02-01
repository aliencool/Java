package UDP;

import java.io.IOException;
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
public class SendTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//创建UPD的Socket
		DatagramSocket ds=new DatagramSocket();
		
		//创建发送的UDP包
		String msg="您好，世界，我的第一个UDP";
		byte [] b=msg.getBytes();
		DatagramPacket dp=new DatagramPacket(b, b.length,InetAddress.getByName("localhost"),10000);
		
		//发送
		ds.send(dp);
		
		//关闭
		ds.close();
	}

}
