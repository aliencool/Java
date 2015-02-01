package Nio_Other;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;


/**
 * @�๦��˵����ѧϰ�ַ�����
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-29 ����11:30:16
 * @�汾��V1.0
 */
public class Nio_Char {
	public static void main(String []agrs) throws Exception
	{
		//1:�鿴֧��ʲô����
		SortedMap<String, Charset> sortedMap = Charset.availableCharsets();
		
		Iterator<Map.Entry<String, Charset>> iterator = sortedMap.entrySet().iterator();
		
		while(iterator.hasNext())
		{
			System.out.println("Key:"+iterator.next().getKey()+"--->"+iterator.next().getValue());
		}
		//2:�����
		Charset charset = Charset.forName("UTF-8");
		//2.1:������
		CharsetEncoder charsetEncoder = charset.newEncoder();
		CharsetDecoder charsetDecoder = charset.newDecoder();
		//3:����
		CharBuffer buffer=CharBuffer.wrap("�Ұ����й�");
		//3.1:����
		ByteBuffer byteBuffer=charsetEncoder.encode(buffer);
		//3.2:����
		System.out.println("����:"+charsetDecoder.decode(byteBuffer));
	}
}
