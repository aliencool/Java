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
	 * �ַ���ָ��Ķ����ǲ��ɸı䣬ָ����һ����ʱ��abc�ǻ����ڵģ�ֻ�ǣ����ò�ͬ
	 */
	private static void stringabcTest() {
		String sr="abc";//��������,�򲻻ᴴ��
		sr="cde";
		String sr1="abc";
		System.out.println(sr);
		System.out.println(sr==sr1);
	}

}
