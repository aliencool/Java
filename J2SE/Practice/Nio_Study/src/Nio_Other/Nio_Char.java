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
 * @类功能说明：学习字符编码
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-29 上午11:30:16
 * @版本：V1.0
 */
public class Nio_Char {
	public static void main(String []agrs) throws Exception
	{
		//1:查看支持什么编码
		SortedMap<String, Charset> sortedMap = Charset.availableCharsets();
		
		Iterator<Map.Entry<String, Charset>> iterator = sortedMap.entrySet().iterator();
		
		while(iterator.hasNext())
		{
			System.out.println("Key:"+iterator.next().getKey()+"--->"+iterator.next().getValue());
		}
		//2:编解码
		Charset charset = Charset.forName("UTF-8");
		//2.1:编码器
		CharsetEncoder charsetEncoder = charset.newEncoder();
		CharsetDecoder charsetDecoder = charset.newDecoder();
		//3:测试
		CharBuffer buffer=CharBuffer.wrap("我爱你中国");
		//3.1:编码
		ByteBuffer byteBuffer=charsetEncoder.encode(buffer);
		//3.2:解码
		System.out.println("解码:"+charsetDecoder.decode(byteBuffer));
	}
}
