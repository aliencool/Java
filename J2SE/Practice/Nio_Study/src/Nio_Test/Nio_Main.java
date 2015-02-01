package Nio_Test;
import java.nio.*;


/**
 * @�๦��˵����ʹ��NIO�Ļ�����1:�������ݣ���ȡ����
 * @���޸��ߣ�  
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-27 ����05:43:01
 * @�汾��V1.0
 */
public class Nio_Main {
	public static  void main(String []args)
	{
		IntBuffer buffer=IntBuffer.allocate(10);
		
		for(int i=0;i<10;i++)
		{
			buffer.put(i+1);
		}
		
		//��ȡ��ʱ����Ҫָ��flip
		buffer.flip();
		
		while(buffer.hasRemaining())
		{
			int single = buffer.get();
			
			System.out.println("Index:"+single);
		}
		
	}
}
