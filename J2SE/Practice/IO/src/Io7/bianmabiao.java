package Io7;
/*1���ٱ�һ��
 *2����0��ʼ len-1
 * */
import java.io.UnsupportedEncodingException;

public class bianmabiao {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String str = "aa���ѽ";
		int len = str.getBytes("utf-8").length;
		for (int i = 1; i < len-1; i++) {
			System.out.println(bytesub(str,i));
		}
	
		
		
	}
	
	
	
	
	
	
	
	public static String bytesub(String str, int len) throws UnsupportedEncodingException {
		byte[] b=str.getBytes("gbk");
		int count=0;
		for (int i = len-1; i>=0; i--) {
			if(b[i]<0) count++;
			else
				break;
		}
		if(count%2==0) return new String(b,0,len);
		else return new String(b,0,len-1);
		
	}
	public static String bytesub2(String str, int len) throws UnsupportedEncodingException {
		byte[] b=str.getBytes("utf-8");
		int count=0;
		for (int i = len-1; i>=0; i--) {
			if(b[i]<0) count++;
			else
				break;
		}
		if(count%3==0) return new String(b,0,len);
		else if(count%3==1) return new String(b,0,len-1);//һ�������
		else return new String(b,0,len-2); //2�������
		
	}






	/*����ٽ�һ��
	 * .getbytes
	 * */
	private static void test1() throws UnsupportedEncodingException {
		byte[] s="���".getBytes("gbk");
		printBytes(s);
		
		//�����ٽ�һ��
		String msg=new String(s,"iso8859-1");
		byte[] by=msg.getBytes("iso8859-1");
		
		String msg1=new String(by,"gbk");
		System.out.println(msg1);
	}

	public static void printBytes(byte[] s) {
		// TODO Auto-generated method stub
		for(byte b:s)
		{
			System.out.println(b);
		}
	}

}
