package Nio_Test_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/**
 * @类功能说明：学习Channel，把思维转换成缓存区与通道！双向的
 * @编写错误的地方：没有使用内存缓冲区
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-28 下午05:19:24
 * @版本：V1.0
 */
public class Channel_Test {
	public static void main(String []agrs) throws Exception
	{
		//1:定义一个文件
		File file = new File("www.txt");
		//2:写进去的地方
		File file_copy = new File("www_copy.txt");
		//3:定义文件输入 输出流
		FileInputStream fileInputStream=new FileInputStream(file);
		FileOutputStream fileOutputStream=new FileOutputStream(file_copy);
		//4:双向通道
		FileChannel fin = fileInputStream.getChannel();
		FileChannel fout = fileOutputStream.getChannel();
		//5:读进缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		int task=0;
		//5.1:读进来
		while((task=fin.read(buffer))!=-1)
		{
			//5.2:position limit都会移动，所以必须重做
			buffer.flip();
			//5.2:写出
			fout.write(buffer);
			//5.3:清空--已经写出到外面了
			buffer.clear();
		}
		
		
		
		
		
		
		fin.close();
		fout.close();
		
		
	}

}
