package Io5;

import java.io.*;
import java.util.Properties;

import javax.management.RuntimeErrorException;

/*到达使用次数给钱
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
		if(!f.exists()) f.createNewFile();//保证文件的存在性
		
		FileInputStream fi=new FileInputStream(f);
		
		
		
		Properties pp=new Properties();
		int count=0;
		pp.load(fi);
		String msg=pp.getProperty("times");//读取times的键值
		
		if(msg!=null)
		{
			count=Integer.parseInt(msg);
			System.out.println("您已经使用"+count+"次");
			if(count==5)
			{
				throw new RuntimeException("超过使用次数");
			}
		}
		
		count++;
		pp.setProperty("times", String.valueOf(count));
		
		FileOutputStream fo=new FileOutputStream(f);
		
		pp.store(fo, "Count");//这里要保存
		
		fo.close();
		fi.close();
		
		
	}

}
