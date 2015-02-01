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
		System.out.println("��ӭʹ���ļ��и���");
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
	 * f:�е��ļ�
	 * dir:ָ��Ŀ��
	 * */
	public static void SpitFileTest(File f,File dir) throws IOException {
		//�ж��û����ļ����Ƿ����
		if(!dir.exists()) dir.mkdirs();
		
		//��ȡ�ļ�
		FileInputStream fis=new FileInputStream(f);
		
		//�����и�ռ����С
		int count=1;
		byte[] byt=new byte[1024*1024];
		
	
		
		//����д��
		int len;
		FileOutputStream fos=null;
		
		while((len=fis.read(byt))!=-1)
		{
			fos=new FileOutputStream(new File(dir,(count++)+".part"));
			fos.write(byt, 0, len);
			
		}	
		//��֪�û��и����
		System.out.println("���и�ķ����ǣ�"+count);
		
		//���������ļ�֪���ļ�����չ��
		setProperties(f,count);
		
		fos.close();
	}
	
	public static void AddFileTest(File f) throws IOException
	{
		//��ȡ�����ļ�
		File[] f1=f.listFiles(new MyFile(".ini"));
		//�����ܶ�������ļ�
		if(f1.length!=1) throw new RuntimeException();
		File config=f1[0];
	
			Properties pp=new Properties();
		FileInputStream fis=new FileInputStream(config);
		pp.load(fis);
		int count=Integer.parseInt(pp.getProperty("spitcount"));
		String name=pp.getProperty("filename");
		
		//��׳���ж�
		if(!f.exists()) throw new NullPointerException();
		
		//����Ƭд������
		ArrayList<FileInputStream> ay=new  ArrayList<FileInputStream>();
		
		for (int i = 1; i <count; i++) {
			ay.add(new FileInputStream(new File(f,i+".part")));
		}
		
		//�ϲ���
		Enumeration<FileInputStream> en=Collections.enumeration(ay);
		
		SequenceInputStream si=new SequenceInputStream(en);
		
		int len;
		byte[] byt=new byte[1024*1024];
		
		
		FileOutputStream fos=new FileOutputStream(f.getAbsolutePath()+"ddfc"+name);
		
		while((len=si.read(byt))!=-1)
		{
			fos.write(byt, 0, len);//д��ĩ��
		}
		fos.close();
	}

}
