package Io7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*2013年8月24日9:59:01
 * RandomAccessFile: r rw rws rwd 
 * 第一：不是Io的体系
 * 第二：只能是文本文件
 * 第三：采用 SET GET来随机读取
 * 第四：一个巨大的字节数组，不会覆盖。而写数据的时候，如果，不指定位置，则从头开始写。
 *   应用：缓冲 断点（多线程写进） 
 * */
public class RandomFileTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		RT();
	}

	private static void RT() throws IOException {
		// TODO Auto-generated method stub
		RandomAccessFile rfs =new RandomAccessFile("random.txt", "rw");
		byte[] b=new byte[8];
		rfs.seek(2*4);//屏蔽前面的8个
		rfs.read(b);
		String s=new String(b);
		System.out.println(s);
	}

	private static void WT() throws FileNotFoundException, IOException {
		RandomAccessFile rfs =new RandomAccessFile("random.txt", "rw");
		rfs.write("hhaa".getBytes());
		rfs.writeInt(97);//写进去是4个字节
		rfs.close();
	}

}
