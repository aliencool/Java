package TeacherJh1;
/*2013年7月6日16:24:23
 * 学习stringbuffer
 * 1:特点:任意类型，插入，改变字符串
 * 2:每次返回stringbuffer与每次16个字符
 * */
public class StringBufferTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("scfd");
		sb.delete(1, 3);//保留头与尾
		String b=sb.substring(1, 3);//去除头与尾
		System.out.println(sb);
		System.out.println(b);
	}

}
