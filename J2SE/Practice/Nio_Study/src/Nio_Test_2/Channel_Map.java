package Nio_Test_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;


/**
 * @类功能说明：学习Channel，使用Map与文件映射，来提高读取文件速度
 * @编写错误的地方：没有使用内存缓冲区
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-28 下午05:19:24
 * @版本：V1.0
 */
public class Channel_Map {
	public static void main(String []agrs) throws Exception
	{
		//1:定义一个文件
		File file = new File("www.txt");
		
		//2:定义文件输入
		FileInputStream fileInputStream = new FileInputStream(file);
		
		//3:双向通道
		FileChannel fin = fileInputStream.getChannel();

		//5:生成channelMap来提高效率
		MappedByteBuffer mappedByteBuffer=fin.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
		
		//6:来查看,Remaining来是否来否数据
		byte [] b=new byte[(int) file.length()];
		int i=0;
		while(mappedByteBuffer.hasRemaining())
		{
			b[i++]=mappedByteBuffer.get();
		}
          
		System.out.println(new String(b));
		
		
		fin.close();
		
		
		
	}

}
