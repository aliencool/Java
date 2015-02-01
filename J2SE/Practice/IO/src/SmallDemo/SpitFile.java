package SmallDemo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

import javax.management.RuntimeErrorException;

/*
 * 
 * */
public class SpitFile {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("欢迎使用文件切割器");
		File f=new File("15.bmp");
		File dir=new File("Spilt");
		SpitFileTest(f,dir);
		AddFileTest(dir);
		
		
	}
	public static void setProperties(File f,int count) throws IOException {
		Properties pp=new Properties();
		pp.setProperty("filename", f.getName());
		pp.setProperty("spitcount", String.valueOf(count));
		
		FileOutputStream fs=new FileOutputStream("F:\\JAVA\\javapj\\Demo12\\Spilt\\set.ini");
		pp.store(fs, "");
		fs.close();
	}
	

	/*
	 * f:切的文件
	 * dir:指定目的
	 * */
	public static void SpitFileTest(File f,File dir) throws IOException {
		//判断用户的文件夹是否存在
		if(!dir.exists()) dir.mkdirs();
		
		//读取文件
		FileInputStream fis=new FileInputStream(f);
		
		//定义切割空间与大小
		int count=1;
		byte[] byt=new byte[1024*1024];
		
	
		
		//分批写进
		int len;
		FileOutputStream fos=null;
		
		while((len=fis.read(byt))!=-1)
		{
			fos=new FileOutputStream(new File(dir,(count++)+".part"));
			fos.write(byt, 0, len);
			
		}	
		//告知用户切割份数
		System.out.println("您切割的份数是："+count);
		
		//设置配置文件知道文件的扩展名
		setProperties(f,count);
		
		fos.close();
	}
	
	public static void AddFileTest(File f) throws IOException
	{
		//获取配置文件
		File[] f1=f.listFiles(new MyFile(".ini"));
		//不可能多个配置文件
		if(f1.length!=1) throw new RuntimeException();
		File config=f1[0];
	
			Properties pp=new Properties();
		FileInputStream fis=new FileInputStream(config);
		pp.load(fis);
		int count=Integer.parseInt(pp.getProperty("spitcount"));
		String name=pp.getProperty("filename");
		
		//健壮性判断
		if(!f.exists()) throw new NullPointerException();
		
		//把碎片写进集合
		ArrayList<FileInputStream> ay=new  ArrayList<FileInputStream>();
		
		for (int i = 1; i <count; i++) {
			ay.add(new FileInputStream(new File(f,i+".part")));
		}
		
		//合并流
		Enumeration<FileInputStream> en=Collections.enumeration(ay);
		
		SequenceInputStream si=new SequenceInputStream(en);
		
		int len;
		byte[] byt=new byte[1024*1024];
		
		
		FileOutputStream fos=new FileOutputStream(f.getAbsolutePath()+"ddfc"+name);
		
		while((len=si.read(byt))!=-1)
		{
			fos.write(byt, 0, len);//写到末端
		}
		fos.close();
	}

}
