package TeacherJh;

public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gouzhaohanshuTest();
		     }

	public static void gouzhaohanshuTest() {
		// TODO Auto-generated method stub
		char []msg={'a','b','c'};
		String sr=new String(msg,0,2);
		System.out.println(sr);
	}

	/**
	 * 字符串指向的对象是不可改变，指向另一个的时候abc是还存在的，只是，引用不同
	 */
	private static void stringabcTest() {
		String sr="abc";//缓冲区有,则不会创建
		sr="cde";
		String sr1="abc";
		System.out.println(sr);
		System.out.println(sr==sr1);
	}

}
