package Io4;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.*;

/*2013��8��21��9:27:53
 * ѧϰFile
 * 1:File:���ֹ���
 * 2:��������
 *        -|��ȡ:lastmodified()����޸�ʱ��  path ���·��  getAbsolutePath ����·��
 *        -|����:1:�����ļ� ���ܴ��� 2:ɾ���ļ��б�����ɾ����������ļ����ļ��� 3:ɾ���ļ��л�ɾ����������ļ�
 *        -|�ж�:�Ƿ����   ���Ƿ����ļ��� ���Ƿ����ļ�ѽ!
 *        -|����:renameto
 *        -|ϵͳ�̷�:listRoot []
 *        -|�̷���������:list []
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
			//�ļ���
			File f=new File("file.txt");
			System.out.println(f.createNewFile());
			System.out.println(f.delete());
			
			//�ļ��е�
			File f1=new File("file\\aa\\bb\\cc");
			System.out.println(f1.mkdirs());
			f1.deleteOnExit();//�˳�ʱɾ��ȫ��
			System.out.println(f1.delete());//ɾ��cc
		
	}

	private static void get() {
		File f=new File("D"+System.getProperty("file.Separator"));
		File f1=new File(f,"a.txt");//�ô�ֱ�Ӳ���f�����ļ�
		
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
