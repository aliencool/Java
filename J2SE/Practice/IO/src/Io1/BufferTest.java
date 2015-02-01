package Io1;


import java.io.*;

/*2013年8月18日20:58:54
 * 学习字符流缓冲区
 * */
public class BufferTest {


	public static void main(String[] args) throws IOException {
		
		
	}
	/*复制文件
	 * */
	public static void Exam() throws FileNotFoundException, IOException {
		String msg=null;
		//读出文件
		FileReader fr=new FileReader("demo1.txt");
		BufferedReader br=new BufferedReader(fr);
		
		//写进文件
		FileWriter fw=new FileWriter("abc.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		
		
		//读取到为NULL
		while((msg=br.readLine())!=null)
		{
			bw.write(msg);
			bw.newLine();
			bw.flush();
		}
		br.close();
		bw.close();
	}

	public static void TestReader() {
		FileReader fr=null;
		BufferedReader bw=null;
		try {
			fr=new FileReader("demo1.txt");
			//必须要与构造器相连
			bw=new BufferedReader(fr);
			String msg=null;
			
			//读取到为NULL
			while((msg=bw.readLine())!=null)
			{
				System.out.println(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(bw!=null)
			{
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void TestWriter() {
		FileWriter fr=null;
		BufferedWriter bw=null;
		try {
			fr=new FileWriter("demo1.txt");
			//必须要与构造器相连
			bw=new BufferedWriter(fr);
			bw.write("abc");
			bw.newLine();//特有方法
			bw.write("abc");
			bw.flush();//万一断电不写这个就悲剧
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(bw!=null)
			{
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
