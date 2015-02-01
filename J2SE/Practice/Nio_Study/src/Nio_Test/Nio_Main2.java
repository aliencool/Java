package Nio_Test;

import java.nio.IntBuffer;

/**
 * @�๦��˵����ʹ���ӻ�����
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-27 ����05:44:18
 * @�汾��V1.0
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
		
		//�ӵڶ�����ʼ
		buffer.position(2);
		//���6��
		buffer.limit(6);
		//��ȡ�ӻ�����
		subBuffer=buffer.slice();
		
		for (int i = 0; i < subBuffer.capacity(); i++) {
				int temp=subBuffer.get(i);
				subBuffer.put(temp-1);
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
