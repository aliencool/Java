package Nio_Test_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;


/**
 * @�๦��˵����ѧϰChannel��ʹ��Map���ļ�ӳ�䣬����߶�ȡ�ļ��ٶ�
 * @��д����ĵط���û��ʹ���ڴ滺����
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-28 ����05:19:24
 * @�汾��V1.0
 */
public class Channel_Map {
	public static void main(String []agrs) throws Exception
	{
		//1:����һ���ļ�
		File file = new File("www.txt");
		
		//2:�����ļ�����
		FileInputStream fileInputStream = new FileInputStream(file);
		
		//3:˫��ͨ��
		FileChannel fin = fileInputStream.getChannel();

		//5:����channelMap�����Ч��
		MappedByteBuffer mappedByteBuffer=fin.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
		
		//6:���鿴,Remaining���Ƿ���������
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
