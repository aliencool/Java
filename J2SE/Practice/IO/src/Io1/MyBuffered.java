package Io1;

import java.io.*;

/*2013年8月19日15:27:27
 * Read
 * Post:是指缓冲区里面我们要取的角标
 * Count:是指缓冲区里面我们还可以取多少次，并重复
 * 
 * Readline
 * 1:定义int来判断
 * 2:判断长度不为0来返回
 * */
public class MyBuffered {

	private Reader fr=null;
	private char[] ch=new char[1024];//原理就是拿一批数据放到缓冲区的数组操作
	private int post=0;//Post:是指缓冲区里面我们要取的角标
	private int count=0;//Count:是指缓冲区里面我们还可以取多少次，并重复
	
	public MyBuffered(Reader fr)
	{
		this.fr=fr;
	}
	
	public int MyRead() throws IOException
	{
		//1,它为0的时候我们必须重新读取，并且还要注意返回负一的情况!
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
