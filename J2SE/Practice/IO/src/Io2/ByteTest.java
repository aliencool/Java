package Io2;

import java.io.*;

/*2013��8��19��21:45:14 
 * FileInputStream:
 * Read:��ȡ�����ֽ�(����Ҫ�����������һ����˵)
 * available:��ȡ�ļ���С��С�ļ�
 * 
 * FileOutputStream:
 * Write:д����ֽڣ��ַ�����getbyte��
 * flush:��û��ˢ�µ�
 * */
public class ByteTest {


	public static void main(String[] args) throws IOException {
	
		
	}

	public static void DURTEST() throws FileNotFoundException, IOException {
		FileOutputStream fos=new FileOutputStream("abc.txt");
		
		fos.write("abc".getBytes());
		
		fos.close();
	}

	public static void ZIJIEDU() throws FileNotFoundException, IOException {
		FileInputStream fis=new FileInputStream("abc.txt");
		
		System.out.println("�ļ���СΪ:"+fis.available());
		
		int len=0;
		byte[] by=new byte[1024];
		
		while((len=fis.read(by))!=-1)
		{
			System.out.println(new String(by,0,len));
		}
	}

}
