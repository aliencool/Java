package IO3;

import java.io.*;

/*2013��8��20��22:15:02
 * һһ��Ӧ
 * */
public class IoCharSet {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		//OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("abc.txt"),"UTF-8");
		//osw.write("���");
		//osw.close();
		
		InputStreamReader isw=new InputStreamReader(new FileInputStream("abc.txt"),"UTF-8");
		char[] ch=new char[1024];
		int len=isw.read(ch);
		String msg=new String(ch,0,len);
		System.out.println(msg);
	}

}
