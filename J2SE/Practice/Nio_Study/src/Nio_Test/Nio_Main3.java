package Nio_Test;

import java.nio.IntBuffer;

/**
 * @�๦��˵����ʹ��ֻ����������ֻ�ܶ�ȡ����ʹ��
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-27 ����05:44:18
 * @�汾��V1.0
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
