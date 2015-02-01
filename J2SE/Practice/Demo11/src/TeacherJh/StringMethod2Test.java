package TeacherJh;
/*2013年6月12日21:35:30
 * 判断与比较
 * 判断:
 * 1:equals equalsIgnoreCase
 * 2:contains
 * 3:startwith endwith
 * */
public class StringMethod2Test {

	public static void main(String[] args) {
		panduanTest();
		bijiaoTest();

	}

	public static void bijiaoTest() {
		// TODO Auto-generated method stub
		
	}

	public static void panduanTest() {
		// TODO Auto-generated method stub
		String msg="abcdef";
		String msg1="ArrayDemo.java";
		System.out.println(msg.equalsIgnoreCase("ABCDEF"));//大小写判断
		System.out.println(msg.contains("abc"));//是否包含
		System.out.println(msg1.startsWith("Array"));//开拓是否包含
		System.out.println(msg1.endsWith(".java"));//结尾是否包含
		
	}

}
