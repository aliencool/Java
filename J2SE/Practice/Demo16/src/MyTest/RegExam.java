package MyTest;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		one();//口吃 替换原则
		two();//IP地址
		three();
	}

	//口吃替换原则
	private static void one() {
		// TODO Auto-generated method stub
		String str="我我我我我..我我我..我我我$$要要要要要**要@@学学学...学学学学^^..学英英英***.英英英英英..语语语..语语__语语语语+++语语";
		//1:截取 第一种
	/*	String[] msg=str.split("[\\.!@#\\$%\\^&\\*\\(_\\+\\-]+");
		
		
		//2:整合
		StringBuffer buffer=new StringBuffer();
		for (int i = 0; i < msg.length-1; i++) {
			buffer.append(msg[i]);
		}
		//替换
		String ms1=buffer.toString();
		String ms2=ms1.replaceAll("(.)\\1+", "$1");
		System.out.println(ms2);
	*/	
		
		//第二种方式
		str=str.replaceAll("[\\.!@#\\$%\\^&\\*\\(_\\+\\-]+", "");
		System.out.println(str);
		str=str.replaceAll("(.)\\1+", "$1");
		System.out.println(str);
		
	}
	//ip排序原则
	private static void two() {
		// TODO Auto-generated method stub
		String ip_str="192.168.10.34 127.0.0.1 3.3.3.3  105.70.11.55";
		//为了好比较，我们补零
		ip_str=ip_str.replaceAll("(\\d+)","00$1");
		
		//只要三位数字, （把前面的0替换成后面三个）0*=00   \d{3}192
		ip_str=ip_str.replaceAll("0*(\\d{3})", "$1");
		
		TreeSet<String> treeSet=new TreeSet<String>();
		
        String []msg=ip_str.split(" +");
        
        for(String msg1:msg)
        {
        	treeSet.add(msg1);
        }
        
        for(String msg2:treeSet)
        {
        	System.out.println(msg2.replaceAll("0*(\\d+)", "$1"));
        }
		
	}
	/*校验邮箱
	 * 
	 * */
	private static void three() {
		// TODO Auto-generated method stub
		Pattern pattern=Pattern.compile("\\w+([_+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		Matcher matcher=pattern.matcher("aasuperkey@163.com");
		
		boolean b=matcher.matches();
		System.out.println(b);
	}

}
