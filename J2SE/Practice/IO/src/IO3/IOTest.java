package IO3;

import java.io.*;

public class IOTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*ѭ����ȡ
		 * 1:�����\n�����ȥ�����ԣ�Ҫ��Ӷ��else
		 * 2:ÿ��ʹ���� Ҫ���
		 * */
		//�������
		InputStream ipt=System.in;
		
		//��¼���ݺ͸���
		int ch;
		int pos=0;
		
		//���建����,OVER����
		char[] str=new char[1024];
		String str1=null;
		
		//ѭ����ȡ��¼��
		while((ch=ipt.read())!=-1)
		{
			if(ch=='\r')continue;
			if(ch=='\n')
			{
				if(ch=='\r')continue;
				if(ch=='\n')
				{
					String st=new String(str,0,pos);
					if("over".equals(st))break;
                    System.out.println(st.toUpperCase());
					pos=0;
				}
				
				
			}
			else
			{
				str[pos]=(char)ch;
				pos++;
			}
			
		}
		
	}

	/*is.close();���ܹأ����˳���������Ȼ�޷�����
	 * */
	public static void XZSTEST() throws IOException {
		InputStream is=System.in;
		int ch=is.read();
		System.out.println(ch);
		int ch1=is.read();
		System.out.println(ch1);
		int ch2=is.read();
		System.out.println(ch2);
	}

}
