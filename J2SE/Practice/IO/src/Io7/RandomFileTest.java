package Io7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*2013��8��24��9:59:01
 * RandomAccessFile: r rw rws rwd 
 * ��һ������Io����ϵ
 * �ڶ���ֻ�����ı��ļ�
 * ���������� SET GET�������ȡ
 * ���ģ�һ���޴���ֽ����飬���Ḳ�ǡ���д���ݵ�ʱ���������ָ��λ�ã����ͷ��ʼд��
 *   Ӧ�ã����� �ϵ㣨���߳�д���� 
 * */
public class RandomFileTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		RT();
	}

	private static void RT() throws IOException {
		// TODO Auto-generated method stub
		RandomAccessFile rfs =new RandomAccessFile("random.txt", "rw");
		byte[] b=new byte[8];
		rfs.seek(2*4);//����ǰ���8��
		rfs.read(b);
		String s=new String(b);
		System.out.println(s);
	}

	private static void WT() throws FileNotFoundException, IOException {
		RandomAccessFile rfs =new RandomAccessFile("random.txt", "rw");
		rfs.write("hhaa".getBytes());
		rfs.writeInt(97);//д��ȥ��4���ֽ�
		rfs.close();
	}

}
