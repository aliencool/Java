package Nio_Test_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/**
 * @�๦��˵����ѧϰChannel����˼άת���ɻ�������ͨ����˫���
 * @��д����ĵط���û��ʹ���ڴ滺����
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-28 ����05:19:24
 * @�汾��V1.0
 */
public class Channel_Test {
	public static void main(String []agrs) throws Exception
	{
		//1:����һ���ļ�
		File file = new File("www.txt");
		//2:д��ȥ�ĵط�
		File file_copy = new File("www_copy.txt");
		//3:�����ļ����� �����
		FileInputStream fileInputStream=new FileInputStream(file);
		FileOutputStream fileOutputStream=new FileOutputStream(file_copy);
		//4:˫��ͨ��
		FileChannel fin = fileInputStream.getChannel();
		FileChannel fout = fileOutputStream.getChannel();
		//5:����������
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		int task=0;
		//5.1:������
		while((task=fin.read(buffer))!=-1)
		{
			//5.2:position limit�����ƶ������Ա�������
			buffer.flip();
			//5.2:д��
			fout.write(buffer);
			//5.3:���--�Ѿ�д����������
			buffer.clear();
		}
		
		
		
		
		
		
		fin.close();
		fout.close();
		
		
	}

}
