package Test;
/*2013��10��23��21:40:21
 *URL openStream==URL openConnection+socket==����Э���socket
 *openConnection:�����Ի�ȡ����ͷ
 * */
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URL_Demo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			String str="http://localhost:8090";
			
			URL url=new URL(str);//����str
			
			int len=0;
			byte[] bs=new byte[1024];
			//�õ�������������Ϣ
			//InputStream fileInputStream=url.openStream(); ��һ��//����InputStream
			//�ڶ���
			URLConnection msg1=url.openConnection();
			System.out.println(msg1.getHeaderField("Server"));
		
	}

}
