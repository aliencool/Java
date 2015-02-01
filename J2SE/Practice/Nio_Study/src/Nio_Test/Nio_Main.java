package Nio_Test;
import java.nio.*;


/**
 * @类功能说明：使用NIO的缓冲区1:生成数据，读取数据
 * @类修改者：  
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-27 下午05:43:01
 * @版本：V1.0
 */
public class Nio_Main {
	public static  void main(String []args)
	{
		IntBuffer buffer=IntBuffer.allocate(10);
		
		for(int i=0;i<10;i++)
		{
			buffer.put(i+1);
		}
		
		//读取的时候需要指定flip
		buffer.flip();
		
		while(buffer.hasRemaining())
		{
			int single = buffer.get();
			
			System.out.println("Index:"+single);
		}
		
	}
}
