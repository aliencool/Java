package Io1;

import java.io.*;

/*2013年8月17日17:10:46
 * FileWriter:第一必须先刷新或者关闭；第二：不存在创建；存在覆盖；
 * FileWriter:构造函数右边加个TRUE可以续写
 * 
 * FileReader:必须明确文件夹文件位置 末尾为-1
 * 
 * LineNumberReader:读取行号 set （设置） get（获取）
 * */
public class FilezifuTest {

	private static final String Line = System.getProperty("line.separator");

	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader("C:\\abc.txt");
		LineNumberReader lr=new LineNumberReader(fr);
		String str=null;
		
		lr.setLineNumber(0);
		while((str=lr.readLine())!=null)
		{
			System.out.println(lr.getLineNumber()+":"+str);
		}
		
	}


	public static void LXCOPY() throws FileNotFoundException, IOException {
		FileReader fr=new FileReader("C:\\abc.txt");
		char[] ch=new char[1024];
		int len=fr.read(ch);
		
		FileWriter fw=new FileWriter("F:\\JAVA\\javapj\\Demo12\\abc.txt");
		fw.write(ch,0, len);
		
		fr.close();
		fw.close();
	}


	/*读取到末尾的时候，最后一次的流不改变
	 * */
	public static void ReaderTest2() throws FileNotFoundException, IOException {
		FileReader filereader=new FileReader("demo1.txt");
		char[] ch=new char[1024];
		int size=0;
		
		while((size=filereader.read(ch))!=-1)
		{
			System.out.println(String.valueOf(ch));
		}
	}



	public static void ReaderTest() throws IOException {
		FileReader filereader=new FileReader("demo1.txt");
		
		int ch=0;
		while((ch=filereader.read())!=-1)//末尾为1
		{
			System.out.print((char)ch);
		}
	}
	
	
	
	/*第一：变量外边
	 *第二：finally里必须加个判断
	 * */
	public static void IoExceptionTest() {
		FileWriter fileterwriter=null;
		try {
			fileterwriter=new FileWriter("demo1.txt",true);
			fileterwriter.write("Hello"+Line+"world");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(fileterwriter!=null)
			{
				try {
					fileterwriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void Test1() throws IOException {
		FileWriter fileterwriter=new FileWriter("demo1.txt",true);//FileWriter:构造函数右边加个TRUE可以续写
		fileterwriter.write("Hello"+Line+"world");
		fileterwriter.append('a');
		fileterwriter.close();
	}

}
