package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.CharBuffer;

/* 2013年10月14日21:43:17
 * 1:创建一个UPD的接收方的Scoket(指定端口，因为，接受是发送的指定端口)
 * 2:创建一个接受包，因为，你要接受包的属性只有数据包最清楚
 * 3:UPD的recevice接到发送放的包，传到创建的包
 * 4:创建的包解析
 * 5:关闭
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
				String ip=dp.getAddress().getHostAddress();//发送的IP
				int port=dp.getPort();//发送的端口
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
