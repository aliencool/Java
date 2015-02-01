package Io1;

import java.io.*;

/*2013��8��17��17:10:46
 * FileWriter:��һ������ˢ�»��߹رգ��ڶ��������ڴ��������ڸ��ǣ�
 * FileWriter:���캯���ұ߼Ӹ�TRUE������д
 * 
 * FileReader:������ȷ�ļ����ļ�λ�� ĩβΪ-1
 * 
 * LineNumberReader:��ȡ�к� set �����ã� get����ȡ��
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


	/*��ȡ��ĩβ��ʱ�����һ�ε������ı�
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
		while((ch=filereader.read())!=-1)//ĩβΪ1
		{
			System.out.print((char)ch);
		}
	}
	
	
	
	/*��һ���������
	 *�ڶ���finally�����Ӹ��ж�
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
		FileWriter fileterwriter=new FileWriter("demo1.txt",true);//FileWriter:���캯���ұ߼Ӹ�TRUE������д
		fileterwriter.write("Hello"+Line+"world");
		fileterwriter.append('a');
		fileterwriter.close();
	}

}
