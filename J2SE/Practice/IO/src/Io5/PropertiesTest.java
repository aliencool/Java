package Io5;
/*2013年8月21日22:35:02
 * 持久化:store(没有中文);
 * 输出:System.out
 * 加载:load
 * 修改:set (修改后要保存)
 * */
import java.io.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/*2013年8月21日21:58:31
 * 
 * */
public class PropertiesTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		// TODO Auto-generated method stub
		Test1();
		
		
	}

	public static void TestLoad(String mychange,String num) throws IOException {
		// TODO Auto-generated method stub
		Properties pt=new Properties();
		FileInputStream fis=new FileInputStream("abc.txt");
		InputStreamReader isr=new InputStreamReader(fis);
		BufferedReader br=new BufferedReader(isr);
		String line=null;
		
		while((line=br.readLine())!=null)
		{
			if(line.startsWith("#"))continue;
			
			String [] msg=line.split("=");
			pt.setProperty(msg[0], msg[1]);
			
		}
	
		Set<String> set=pt.stringPropertyNames();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{	
			String msg=it.next();
			if(msg.equals(mychange))
			pt.setProperty(mychange, num);
		}
		
		
		FileWriter fw=new FileWriter("abc.txt");
		pt.store(fw, "name+age");
		fw.close();
		
	
		br.close();
		
	}

	private static void Test1() throws IOException {
		Properties pp=new Properties();
		
		//存
		pp.setProperty("a", "97");
		pp.setProperty("b", "98");
		pp.setProperty("c", "99");
		
		//取
		Set<String> set=pp.stringPropertyNames();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{	
			String msg=it.next();
			String name=pp.getProperty(msg);
			System.out.println(msg+":"+name);
		}
		
		//取1
		pp.list(System.out);
		
		//存
		OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("abc.txt"),"utf-8") ;
		
		pp.store(osw, "name+age");
		
		osw.close();
	}

}
