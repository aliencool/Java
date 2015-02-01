package Io7;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
/*2013年8月25日13:29:51
 * 必须使用多线程; 
 * 思想有点不同;
 * 必须使用new thread();
 * */
public class OtherIo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		ByteArrayInputStream bas=new ByteArrayInputStream("你好".getBytes());
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		int len=0;
		byte[] b=new byte[1024];
		while((len=bas.read(b))!=-1)
		{
			bos.write(b,0,len);
		}
		System.out.println(bos.toString());
		
	}



	private static void DataRead() throws FileNotFoundException, IOException {
		DataInputStream dis=new DataInputStream(new FileInputStream("abc.txt"));
		String s=dis.readUTF();
		System.out.println(s);
	}



	private static void DataTest() throws FileNotFoundException, IOException {
		DataOutputStream dos=new DataOutputStream(new FileOutputStream("abc.txt"));
		dos.writeUTF("你好");
		dos.close();
	}

	
	
	private static void other1() throws IOException {
		PipedInputStream pi=new PipedInputStream();
		PipedOutputStream po=new PipedOutputStream();
		pi.connect(po);
		
		new Thread(new Read(pi)).start();
		new Thread(new Write(po)).start();
	}

}
class Read implements Runnable
{
	private PipedInputStream pi;
	
	public Read(PipedInputStream pi) {
		super();
		this.pi = pi;
	}
	public void run() {
		int len=0;
		byte[] b=new byte[1024];
		try {
			while((len=pi.read(b))!=-1)
			{
				String s=new String(b,0,len);
				System.out.println(String.valueOf(s));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class Write implements Runnable
{
	private PipedOutputStream pw;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			pw.write("你好".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(pw!=null)
				try {
					pw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	public Write(PipedOutputStream pw) {
		super();
		this.pw = pw;
	}
	

}