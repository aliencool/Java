package Io4;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.*;

/*2013年8月21日9:27:53
 * 学习File
 * 1:File:多种构造
 * 2:常见方法
 *        -|获取:lastmodified()最后修改时间  path 相对路径  getAbsolutePath 绝对路径
 *        -|创建:1:存在文件 不能创建 2:删除文件夹必须先删除完里面的文件和文件夹 3:删除文件夹会删除最里面的文件
 *        -|判断:是否存在   再是否是文件夹 再是否是文件呀!
 *        -|剪切:renameto
 *        -|系统盘符:listRoot []
 *        -|盘符所有内容:list []
 * */
public class FileTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
			
		List();
	}

	private static void List() {
		// TODO Auto-generated method stub
		File f=new File("c:\\");
		String[] str=f.list();
		for(String msg:str)
		{
			System.out.println(msg);
		}
	}

	public static void changceMAXdir() {
		File[] f1=File.listRoots();
		File file=f1[0];
		for (int i = 0; i < f1.length; i++) {
			if(file.getFreeSpace()<f1[i].getFreeSpace())
			{
				file=f1[i];
			}	
		}
			System.out.println(file);
	}

	public static void renameto() {
		// TODO Auto-generated method stub
		File f=new File("file1");
		File f1=new File("file2");
		f.renameTo(f1);
	}

	public static void panduan() throws IOException {
		// TODO Auto-generated method stub
		File f=new File("file");
		f.createNewFile();
		System.out.println(f.exists());
		System.out.println(f.isDirectory());
		System.out.println(f.isFile());
	}

	public static void crate() throws IOException {
			//文件的
			File f=new File("file.txt");
			System.out.println(f.createNewFile());
			System.out.println(f.delete());
			
			//文件夹的
			File f1=new File("file\\aa\\bb\\cc");
			System.out.println(f1.mkdirs());
			f1.deleteOnExit();//退出时删除全部
			System.out.println(f1.delete());//删除cc
		
	}

	private static void get() {
		File f=new File("D"+System.getProperty("file.Separator"));
		File f1=new File(f,"a.txt");//好处直接操作f对象文件
		
		File f2=new File("abc.txt");
		long time=f2.lastModified();
		Date date=new Date(time); 
		DateFormat df=DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
		String str_time=df.format(date);
		
		
		System.out.println(f2.getName());
		System.out.println(str_time);
		System.out.println(f2.getAbsolutePath());
	}

}
