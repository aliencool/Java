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
		one();//�ڳ� �滻ԭ��
		two();//IP��ַ
		three();
	}

	//�ڳ��滻ԭ��
	private static void one() {
		// TODO Auto-generated method stub
		String str="����������..������..������$$ҪҪҪҪҪ**Ҫ@@ѧѧѧ...ѧѧѧѧ^^..ѧӢӢӢ***.ӢӢӢӢӢ..������..����__��������+++����";
		//1:��ȡ ��һ��
	/*	String[] msg=str.split("[\\.!@#\\$%\\^&\\*\\(_\\+\\-]+");
		
		
		//2:����
		StringBuffer buffer=new StringBuffer();
		for (int i = 0; i < msg.length-1; i++) {
			buffer.append(msg[i]);
		}
		//�滻
		String ms1=buffer.toString();
		String ms2=ms1.replaceAll("(.)\\1+", "$1");
		System.out.println(ms2);
	*/	
		
		//�ڶ��ַ�ʽ
		str=str.replaceAll("[\\.!@#\\$%\\^&\\*\\(_\\+\\-]+", "");
		System.out.println(str);
		str=str.replaceAll("(.)\\1+", "$1");
		System.out.println(str);
		
	}
	//ip����ԭ��
	private static void two() {
		// TODO Auto-generated method stub
		String ip_str="192.168.10.34 127.0.0.1 3.3.3.3  105.70.11.55";
		//Ϊ�˺ñȽϣ����ǲ���
		ip_str=ip_str.replaceAll("(\\d+)","00$1");
		
		//ֻҪ��λ����, ����ǰ���0�滻�ɺ���������0*=00   \d{3}192
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
	/*У������
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
