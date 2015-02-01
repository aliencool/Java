package Nio_Other;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @�๦��˵����ʹ���ļ���
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-29 ����10:46:17
 * @�汾��V1.0
 */
public class Nio_Lock {
	public static void main(String []agrs) throws Exception
	{
		//1:�ļ�
		File file=new File("www.txt");
		//2:������
		FileOutputStream fileOutputStream=new FileOutputStream(file,true);
		//3:���ж�д
		FileChannel channel=fileOutputStream.getChannel();
		//4:����
		FileLock fileLock=channel.tryLock();
		
		while(fileLock!=null)
		{
			Thread.sleep(3000);
			fileLock.release();
		}
		channel.close();
		
	}
}
