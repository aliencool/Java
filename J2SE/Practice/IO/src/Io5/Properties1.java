package Io5;

import java.io.*;
import java.util.Properties;

import javax.management.RuntimeErrorException;

/*����ʹ�ô�����Ǯ
 * 
 * */
public class Properties1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		getAppcount();
	}

	private static void getAppcount() throws IOException {
		File f=new File("abc.txt");
		if(!f.exists()) f.createNewFile();//��֤�ļ��Ĵ�����
		
		FileInputStream fi=new FileInputStream(f);
		
		
		
		Properties pp=new Properties();
		int count=0;
		pp.load(fi);
		String msg=pp.getProperty("times");//��ȡtimes�ļ�ֵ
		
		if(msg!=null)
		{
			count=Integer.parseInt(msg);
			System.out.println("���Ѿ�ʹ��"+count+"��");
			if(count==5)
			{
				throw new RuntimeException("����ʹ�ô���");
			}
		}
		
		count++;
		pp.setProperty("times", String.valueOf(count));
		
		FileOutputStream fo=new FileOutputStream(f);
		
		pp.store(fo, "Count");//����Ҫ����
		
		fo.close();
		fi.close();
		
		
	}

}
