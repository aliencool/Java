package Io2;

import java.io.*;

/*2013年8月19日21:45:14 
 * FileInputStream:
 * Read:读取的是字节(中文要读二次相对于一次来说)
 * available:获取文件大小和小文件
 * 
 * FileOutputStream:
 * Write:写入的字节（字符串用getbyte）
 * flush:是没有刷新的
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
		
		System.out.println("文件大小为:"+fis.available());
		
		int len=0;
		byte[] by=new byte[1024];
		
		while((len=fis.read(by))!=-1)
		{
			System.out.println(new String(by,0,len));
		}
	}

}
