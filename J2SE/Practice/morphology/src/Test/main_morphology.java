package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class main_morphology {
	
	/**
	 * @param args
	 * 状态模式->解析C语言词法分析 5个状态   生成为5类
	 * 1:关键字
	 * 2:常数
	 * 3:界符
	 * 4:运算符
	 * 5:标示符 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//变量
		//1:save:保存读进内存的字符
		char []msg;
		//2:size:读进内存的字符大小
		int count=0;
		//3:message
		int len=0;
		//4:flag 是否读到结束符
		int i=0;
		
		
		//读进内存
		InputStream inputStream=new FileInputStream("programmer.txt");
		//得到文件长度
		count=inputStream.available();
		msg=new char[count];
		//开始读
		
		while((len=inputStream.read())!=-1)
		{
			msg[i]=(char)len;
			i++;
		}
		
		Work.setMsg(msg);
		
		//运行
		Work work=new Work();
		System.out.println("词法分析表开始执行:");
		while(Work.stats!=-1)
		{
			work.analysis();
			Work.p++;
			work.setState(new Digit_Letter_State());
		}

	/*	StringBuilder sentence = new StringBuilder("This is an apple");
		char c;
		int p1, p2;
		
		p1 = sentence.length();
		System.out.println("1L"+p1);
		while (p1 > 0) {
			p1--;
			p2 = p1;
			
			while (p1 >= 0 && sentence.charAt(p1) != ' ') {
				p1--;
			}
			
			int ww = p2 - p1;
		
			p2 = p1 + 1;
			
			while (p1 + ww >= p2) {
				System.out.print(sentence.charAt(p2));
				p2++;
			}
			
			if (p1 >= 0) {
				System.out.print(' ');
			}
		}
		*/
		
		
		
	
	}

}
