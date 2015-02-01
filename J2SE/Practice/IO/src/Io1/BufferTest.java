package Io1;


import java.io.*;

/*2013��8��18��20:58:54
 * ѧϰ�ַ���������
 * */
public class BufferTest {


	public static void main(String[] args) throws IOException {
		
		
	}
	/*�����ļ�
	 * */
	public static void Exam() throws FileNotFoundException, IOException {
		String msg=null;
		//�����ļ�
		FileReader fr=new FileReader("demo1.txt");
		BufferedReader br=new BufferedReader(fr);
		
		//д���ļ�
		FileWriter fw=new FileWriter("abc.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		
		
		//��ȡ��ΪNULL
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
			//����Ҫ�빹��������
			bw=new BufferedReader(fr);
			String msg=null;
			
			//��ȡ��ΪNULL
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
			//����Ҫ�빹��������
			bw=new BufferedWriter(fr);
			bw.write("abc");
			bw.newLine();//���з���
			bw.write("abc");
			bw.flush();//��һ�ϵ粻д����ͱ���
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
