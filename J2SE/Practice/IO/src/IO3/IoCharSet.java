package IO3;

import java.io.*;

/*2013年8月20日22:15:02
 * 一一对应
 * */
public class IoCharSet {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		//OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("abc.txt"),"UTF-8");
		//osw.write("你好");
		//osw.close();
		
		InputStreamReader isw=new InputStreamReader(new FileInputStream("abc.txt"),"UTF-8");
		char[] ch=new char[1024];
		int len=isw.read(ch);
		String msg=new String(ch,0,len);
		System.out.println(msg);
	}

}
