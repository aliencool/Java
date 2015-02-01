package Io5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*把一个文件夹下面所有文件的扩展名写入到文件
 * 
 * */

public class FileTest {

	/**
	 * @param args
	 * @throws IOException 
	 */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f =new File("bin");
		NameFileter nf=new NameFileter();
		List<File> l=new ArrayList<File>();
		getkzTest(f,nf,l);	 
		Test(l);
		
		
		
	}

	public static void getkzTest(File f,FilenameFilter ff,List<File> list) throws IOException {
		if(!f.exists())
		{
			throw new NullPointerException();
		}
		
		File[] f1=f.listFiles();
		for (int i = 0; i < f1.length; i++) {
			if(f1[i].isDirectory())
			{
				getkzTest(f1[i],ff,list);
			}
			else
			{	
				if(ff.accept(f, ".java"))
				list.add(f1[i]);
			}
		}	
		
		
		
	}

	public static void Test(List<File> list) throws IOException {
			BufferedWriter bw=new BufferedWriter(new FileWriter("abc1.txt"));
			for(File f:list)
			{
				bw.write(f.getAbsolutePath());
				bw.newLine();
				bw.flush();
			}
			
			bw.close();
	}

}
