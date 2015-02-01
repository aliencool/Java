package Io1;

import java.io.*;

/*2013��8��19��15:27:27
 * Read
 * Post:��ָ��������������Ҫȡ�ĽǱ�
 * Count:��ָ�������������ǻ�����ȡ���ٴΣ����ظ�
 * 
 * Readline
 * 1:����int���ж�
 * 2:�жϳ��Ȳ�Ϊ0������
 * */
public class MyBuffered {

	private Reader fr=null;
	private char[] ch=new char[1024];//ԭ�������һ�����ݷŵ����������������
	private int post=0;//Post:��ָ��������������Ҫȡ�ĽǱ�
	private int count=0;//Count:��ָ�������������ǻ�����ȡ���ٴΣ����ظ�
	
	public MyBuffered(Reader fr)
	{
		this.fr=fr;
	}
	
	public int MyRead() throws IOException
	{
		//1,��Ϊ0��ʱ�����Ǳ������¶�ȡ�����һ�Ҫע�ⷵ�ظ�һ�����!
		if(count==0)
		{
			count=fr.read(ch);
			post=0;
		}
		if(count<0)
		{
			return -1;
		}
		
		char ch1=ch[post++];
		count--;
		return ch1;
		
	}
	
	public String MyReadLine() throws IOException
	{
		StringBuilder sb=new StringBuilder();
		int ch=0;
		
		while((ch=MyRead())!=-1)
		{
			if(ch=='\r')continue;
			if(ch=='\n')return sb.toString();
			
			sb.append((char)ch);
			
		}
		if(sb.length()!=0)
		{
			return sb.toString();
		}
		return null;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
