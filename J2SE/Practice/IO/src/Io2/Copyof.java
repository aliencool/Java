package Io2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*2013年8月19日22:10:55
 * 建议使用Buffered
 * */
public class Copyof {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		copy1();
		copy2();
		copy3();
	}

	public static void copy3() throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("abc.mp3");
		FileOutputStream fos=new FileOutputStream("abc.mp3");
		
		byte[] by=new byte[fis.available()];//大文件不适用
		
		fos.write(by);
		fis.close();
		fos.close();
	}

	public static void copy2() throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("abc.mp3");
		BufferedInputStream bis=new BufferedInputStream(fis);
		FileOutputStream fos=new FileOutputStream("abc.mp3");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		
		int len=0;
		
		while((len=bis.read())!=-1)
		{
			bos.write(len);//一定不要刷新不然会变很慢
		}
		fis.close();
		fos.close();
	}

	public static void copy1() throws IOException {
		FileInputStream fis=new FileInputStream("abc.mp3");
		FileOutputStream fos=new FileOutputStream("abc.mp3");
		
		byte[] by=new byte[1024];
		int len=0;
		while((len=fis.read(by))!=-1)//一定加by不然会爆
		{
			fos.write(by, 0, len);
		}
		fis.close();
		fos.close();
	}

}
