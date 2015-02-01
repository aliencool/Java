package TCPIP4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Upload implements Runnable {
	private Socket s;
	private PrintWriter printWriter;
	private FileOutputStream fos;
	private int count_pictuer=0;
	public Upload(Socket s) {
		super();
		this.s = s;
	}
	public void run() {
		// TODO Auto-generated method stub
		try{
			String ip=s.getLocalAddress().getHostAddress();
			File f=new File("pic");
			File f2=new File(f,ip+".jpg");
			if(!f.exists()){
				f.mkdir();
			}
			while(f2.exists())
			{
				f2=new File(f,ip+"("+(++count_pictuer)+")"+".jpg");
			}
			
			
			printWriter=new PrintWriter(s.getOutputStream(),true);//��ͻ��˷�����Ϣ
			fos=new FileOutputStream(f2);//�����ͻ��˵������µ��ļ�
			InputStream up=s.getInputStream();//������������
			
			byte [] by=new byte[1024];
			int count=0;
			
			while((count=up.read(by))!=-1)
			{
				fos.write(by, 0, count);
				fos.flush();
			}
			printWriter.write("�ϴ��ɹ�");//��ͻ��˷�����Ϣ
			
		}
		catch(Exception e){}
		finally
		{
			if(printWriter!=null) printWriter.close();
			if(s!=null)
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(fos!=null)
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}

}
