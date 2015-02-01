package TeacherJh;
/*2013年6月12日17:35:40
 * 1:length:长度
 * 2:CharAt:获取字符位置
 * 3:Indexof(int):根据前字符获取位置
 * 4:LastIndexof(int):根据后字符获取位置
 * 5:substring:截取字符(包括头，不包括尾)
 * 6:split(规则):截取规则字符
 * 7:toCharArray:转换为char (数组)
 * 8:getbytes:转换为byte(数组)
 * 9:toupperCast:大写  toLowerCast:小写
 * 10:replace(要替换掉,替换):替换
 * 11:trim(去掉头尾空格) 
 *    valueof():基本数据类型转换
 *    copyvalueof();字符转换为数组
 * */
public class StringMethodTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stringmethodtest();
		stringmethodtest1();
	}

	public static void stringmethodtest1() {
		// TODO Auto-generated method stub
		String msg="张三,李四,王五";
		String[] split=msg.split(",");//split存放的正则表达式(\\.)
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
		}
		
		char[] chs=msg.toCharArray();//转换为一个一个
		String.copyValueOf(chs);
		for (int i = 0; i < chs.length; i++) {
			System.out.println(chs[i]);
		}
		
		byte[] bt=msg.getBytes();
		for (int i = 0; i < chs.length; i++) {
			System.out.println(bt[i]);//GB2312最高位为1
		}
		
		System.out.println("jovo".replace("jovo","java"));
	}

	public static void stringmethodtest() {
		String msg="abcdae";
		System.out.println("SubString:"+msg.substring(2));
		System.out.println("SubString:"+msg.substring(2,5));//包含begin,不包含end
		System.out.println("Length:"+msg.length());//6
		System.out.println("charAt:"+msg.charAt(3));//d
		System.out.println("indexof:"+msg.indexOf('a'));//0
		System.out.println("Lastindexof:"+msg.lastIndexOf('a'));//4
		
	}

}
