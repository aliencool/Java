package Io4;

import java.io.File;

/*2013��8��21��16:57:47
 * ����--���
 * */
public class FileTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f=new File("F:\\JAVA\\javapj\\Demo12\\file2");
		
		
		Delete(f);

	}

	private static void Delete(File f) {
		// TODO Auto-generated method stub
		if(!f.exists()) throw new NullPointerException("ss");
		System.out.println(f.getName());
		File[] f1=f.listFiles();
		for (int i = 0; i < f1.length; i++) {
			if(f1[i].isDirectory())
			{
				Delete(f1[i]);
				f1[i].delete();
			}
			else
			{
				//ɾ��Ŀ¼�µ��ļ�
				f1[i].delete();
			}
			
		}
		f.delete();	
	}

	public static void Test1(File f,int level) {
		System.out.println(getspace(level)+f.getName());
		File[] f1=f.listFiles();
		++level;
		for (int i = 0; i < f1.length; i++) {
			if(f1[i].isDirectory())
			{
				Test1(f1[i],level);
			}
			else
			{
				System.out.println(getspace(level)+f1[i].getName());
			}
		}
	}

	private static String getspace(int level) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < level; i++) {
			sb.append("     ");
		}
		return sb.toString();
	}

}
