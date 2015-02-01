package Io6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

/*2013年8月22日22:07:08
 * PrintStream:字符串 文件对象 字节输出流
 * print:按照原有的输出
 * 
 * PrintWriter:字符流
 * */
public class PrintTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=new PrintWriter(new FileWriter("ac.txt"),true);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String line=null;
		
		while ((line=br.readLine())!=null)
		{
			pw.println(line);
		}
		pw.close();
		br.close();
		
	}

	private static void Test1() throws FileNotFoundException {
		PrintStream pw=new PrintStream("ab.txt");
		pw.print("aaa");
		pw.close();
	}

}
