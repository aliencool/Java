package MyReg;
/*2013��10��26��22:15:50
 * ѧϰ����
 * */
import java.util.regex.*;;
public class RegTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Reg_4();
	}
	/*ƥ�� ����
	 * */
	private static void Reg_1() {
	
		String text="15800025052";
		
		
		String reg="[1-9][0-9]{4,14}";//ƥ��QQ
		String reg1="1[358]\\d{9}";//ƥ���ֻ�
		
		
		boolean b=	text.matches(reg);
		System.out.println(b);
	}
	
	/*
	 * �и�:
	 *  ������:
	 *  	�����ڵ���һ����!
	 *  	��0��ȫ����!	
	 * */
	private static void Reg_2() {
		// TODO Auto-generated method stub
		//
		String msg="zhangsan###lisi@@@@zhaoliu";
		
		
		String regex="[ \\.]+";
		String regex1="(.)\\1+";
		
		String []spit=msg.split(regex1);
		
		for(String name:spit)
		{
			System.out.println(name);
		}
	}
	
	
	/*�滻
	 *   ��Ҫѧϰ����ȥ$x ��ʾ��ȥ��x����
	 *   �ֻ����룬�������
	 * */
	private static void Reg_3() {
		// TODO Auto-generated method stub
		String msg="zhangsan###lisi@@@@zhaoliu";
		/**
		 * ��Ԫ���ű�ʾ���õ�һ��
		 * z h ��ƥ�� ���ԣ�ֱ��������
		 * t t ƥ����,���ԣ��õ��ǵ�һ�������ڵ�
		 * */
		String replace=msg.replaceAll("(.)\\1+", "$1");
		System.out.println(replace);
		
		String msg1="15800025052";
		String replace1=msg1.replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1****$3");
		System.out.println(replace1);
	}
	
	/*��ȡ
	 * 
	 * */
	private static void Reg_4() {
		// TODO Auto-generated method stub
		//�����������
		Pattern pattern=Pattern.compile("\\b\\w{3}\\b");
		//����ƥ������
		Matcher matcher=pattern.matcher("daa jia hao,hah nin hao!");
		//����
		System.out.println(matcher.matches());
		while(matcher.find())
		{
			System.out.println(matcher.group());
			System.out.println("Start:"+matcher.start()+"End:"+matcher.end());
		}
	}
}
