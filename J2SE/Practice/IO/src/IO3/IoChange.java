package IO3;
import java.io.*;
/*2013年8月20日21:50:12
 * 学习转:
 * 1:文件-》控制台
 * 2：控制台-》控制台
 * */
public class IoChange {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		 Test1();
		
	}

	public static void Test2() throws FileNotFoundException, IOException {
		 FileInputStream ips=new FileInputStream("abc.txt");
		 InputStreamReader ipsr=new InputStreamReader(ips);
		 BufferedReader bfr=new BufferedReader(ipsr); 
		 
		 OutputStream ops=System.out;//printStream多态
		 OutputStreamWriter opr=new OutputStreamWriter(ops);
		 BufferedWriter bfw=new BufferedWriter(opr);
		 String msg=null;
		 
		 while((msg=bfr.readLine())!=null)
		 {
			 if(msg.equals("over")) break;
			 bfw.write(msg.toUpperCase());
			 bfw.flush();

		 }
		 bfw.close();
		 bfr.close();
	}

	public static void Test1() throws IOException {
		 InputStream ips=System.in;
		 InputStreamReader ipsr=new InputStreamReader(ips);
		 BufferedReader bfr=new BufferedReader(ipsr); 
		 
		 OutputStream ops=System.out;
		 OutputStreamWriter opr=new OutputStreamWriter(ops);
		 BufferedWriter bfw=new BufferedWriter(opr);
		 
		 String msg=null;
		 
		 while((msg=bfr.readLine())!=null)
		 {
			 if(msg.equals("over")) break;
			 bfw.write(msg); 
			 bfw.flush();

		 }
		 bfw.close();
		 bfr.close();
	}

}
