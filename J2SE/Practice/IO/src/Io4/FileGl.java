package Io4;

import java.io.File;

/*2013年8月21日15:42:20
 * 学习过滤器:把全部东西拿来，然后，再过滤，过滤后生成新的
 * 1:它是拿全部数据来过滤
 * 2:专门建一个类来使用过滤关键字
 * 3:FilenameFilter[文件名过滤（string）] FileFiler[文件类型过滤（File）]
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
