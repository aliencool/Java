package Io4;

import java.io.File;

/*2013��8��21��15:42:20
 * ѧϰ������:��ȫ������������Ȼ���ٹ��ˣ����˺������µ�
 * 1:������ȫ������������
 * 2:ר�Ž�һ������ʹ�ù��˹ؼ���
 * 3:FilenameFilter[�ļ������ˣ�string��] FileFiler[�ļ����͹��ˣ�File��]
 * */
public class FileGl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GlFilename();

	}

	private static void GlFilename() {
		File f=new File("C:\\");
		String[] name=f.list(new FileNameFilterGL(".txt"));
		
		for(String msg:name)
		{
			System.out.println(msg);
		}
	}
	
	private static void GlFile() {
		File f=new File("C:\\");
		File[] name=f.listFiles(new FileFiler());
		for(File msg:name)
		{
			System.out.println(msg);
		}
	}

}
