package MyReg;
/*2013年10月26日22:15:50
 * 学习正则
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
	/*匹配 数字
	 * */
	private static void Reg_1() {
	
		String text="15800025052";
		
		
		String reg="[1-9][0-9]{4,14}";//匹配QQ
		String reg1="1[358]\\d{9}";//匹配手机
		
		
		boolean b=	text.matches(reg);
		System.out.println(b);
	}
	
	/*
	 * 切割:
	 *  引出组:
	 *  	括号内的算一个组!
	 *  	第0是全部组!	
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
	
	
	/*替换
	 *   主要学习：拿去$x 表示拿去第x个组
	 *   手机号码，给予分组
	 * */
	private static void Reg_3() {
		// TODO Auto-generated method stub
		String msg="zhangsan###lisi@@@@zhaoliu";
		/**
		 * 美元符号表示：拿第一组
		 * z h 不匹配 所以，直接跳过。
		 * t t 匹配了,所以，拿的是第一个括号内的
		 * */
		String replace=msg.replaceAll("(.)\\1+", "$1");
		System.out.println(replace);
		
		String msg1="15800025052";
		String replace1=msg1.replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1****$3");
		System.out.println(replace1);
	}
	
	/*获取
	 * 
	 * */
	private static void Reg_4() {
		// TODO Auto-generated method stub
		//建立正则对象
		Pattern pattern=Pattern.compile("\\b\\w{3}\\b");
		//建立匹配引擎
		Matcher matcher=pattern.matcher("daa jia hao,hah nin hao!");
		//查找
		System.out.println(matcher.matches());
		while(matcher.find())
		{
			System.out.println(matcher.group());
			System.out.println("Start:"+matcher.start()+"End:"+matcher.end());
		}
	}
}
