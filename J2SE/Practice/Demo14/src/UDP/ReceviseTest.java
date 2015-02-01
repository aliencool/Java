package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/* 2013年10月14日21:43:17
 * 1:创建一个UPD的接收方的Scoket(指定端口，因为，接受是发送的指定端口)
 * 2:创建一个接受包，因为，你要接受包的属性只有数据包最清楚
 * 3:UPD的recevice接到发送放的包，传到创建的包
 * 4:创建的包解析
 * 5:关闭
 * */
public class ReceviseTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//1 创建一个UPD的接收方的Scoket
		DatagramSocket ds=new DatagramSocket(10000);
		
		//2 创建一个包来解析发送端
		byte []buf=new byte[1024];
		DatagramPacket dp=new DatagramPacket(buf, buf.length);
		//3 接受包传给创建的包
		ds.receive(dp);//阻塞
		//解析
		String ip=dp.getAddress().getHostAddress();//发送的IP
		int port=dp.getPort();//发送的端口
		String text=new String(dp.getData(),0,dp.getData().length);
		System.out.println("Ip:"+ip+"端口:"+port+"发送方的信息:"+text);
		//关闭
		ds.close();
	}

}
