package IO3;

import java.io.*;

public class IOTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*循环读取
		 * 1:它会把\n加入进去，所以，要添加多个else
		 * 2:每次使用完 要清空
		 * */
		//定义键盘
		InputStream ipt=System.in;
		
		//记录数据和个数
		int ch;
		int pos=0;
		
		//定义缓冲区,OVER结束
		char[] str=new char[1024];
		String str1=null;
		
		//循环读取并录入
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

	/*is.close();不能关，关了除开重启不然无法开启
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
