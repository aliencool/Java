package Nio_Test;

import java.nio.IntBuffer;

/**
 * @类功能说明：使用只读缓冲区，只能读取不能使用
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-27 下午05:44:18
 * @版本：V1.0
 */
public class Nio_Main3 {
	public static  void main(String []args)
	{
		IntBuffer buffer = IntBuffer.allocate(10);
		
		
		
		for(int i=0;i<10;i++)
		{
			buffer.put(i+1);
		}
		
		buffer.rewind();
		
		
		IntBuffer subBuffer=buffer.asReadOnlyBuffer();
		
		
		while(buffer.hasRemaining())
		{
			int single = buffer.get();
			
			System.out.println("Index:"+single);
		}
		
		
		
	}
}
