package Nio_Test;

import java.nio.IntBuffer;

/**
 * @类功能说明：使用子缓冲区
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-27 下午05:44:18
 * @版本：V1.0
 */
public class Nio_Main2 {
	public static  void main(String []args)
	{
		IntBuffer buffer = IntBuffer.allocate(10);
		IntBuffer subBuffer=null;
		
		
		for(int i=0;i<10;i++)
		{
			buffer.put(i+1);
		}
		
		//从第二个开始
		buffer.position(2);
		//最多6个
		buffer.limit(6);
		//获取子缓冲区
		subBuffer=buffer.slice();
		
		for (int i = 0; i < subBuffer.capacity(); i++) {
				int temp=subBuffer.get(i);
				subBuffer.put(temp-1);
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
