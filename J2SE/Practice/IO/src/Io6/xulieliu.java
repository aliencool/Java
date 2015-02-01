package Io6;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/*2013年8月23日10:27:50
 * 序列流(源-字节):
 * 1:先判断有没有下一个，有读下一个负一，直到最后一个负一
 * 2:Vector的枚举来使用
 * */
public class xulieliu {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<FileInputStream> v=new ArrayList<FileInputStream>();
		v.add(new FileInputStream("ab.txt"));
		v.add(new FileInputStream("abc.txt"));
		v.add(new FileInputStream("abc1.txt"));
		
		v.add(new FileInputStream("ac.txt"));
		Enumeration<FileInputStream> en=enumeration(v);
		SequenceInputStream se=new SequenceInputStream(en);

		
		FileOutputStream fw=new FileOutputStream("total.txt");
		
		byte[] a=new byte[1024];
		int len=0;
		
		while((len=se.read(a))!=-1)
		{
			fw.write(a, 0, len);
		}
		
		fw.close();
		se.close();
		
	}

	private static <T> Enumeration<T> enumeration(final Collection<T> s) {
		// TODO Auto-generated method stub
		return new Enumeration<T>()
		{
			Iterator<T> it=s.iterator();
			@Override
			public boolean hasMoreElements() {
				// TODO Auto-generated method stub
				return it.hasNext();
			}

			@Override
			public T nextElement() {
				// TODO Auto-generated method stub
				return it.next();
			}
			
		};
		
	}

	private static void Test() throws FileNotFoundException, IOException {
		Vector<FileInputStream> v=new Vector<FileInputStream>();
		v.addElement(new FileInputStream("ab.txt"));
		v.addElement(new FileInputStream("abc.txt"));
		v.addElement(new FileInputStream("abc1.txt"));
		v.addElement(new FileInputStream("ac.txt"));
		Enumeration<FileInputStream> en=v.elements();
		
		SequenceInputStream se=new SequenceInputStream(en);
		
		FileOutputStream fw=new FileOutputStream("total.txt");
		
		byte[] a=new byte[1024];
		int len=0;
		
		while((len=se.read(a))!=-1)
		{
			fw.write(a, 0, len);
		}
		
		fw.close();
		se.close();
	}

}
