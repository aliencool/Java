package TeacherJh;
/*2013��6��12��21:35:30
 * �ж���Ƚ�
 * �ж�:
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
		System.out.println(msg.equalsIgnoreCase("ABCDEF"));//��Сд�ж�
		System.out.println(msg.contains("abc"));//�Ƿ����
		System.out.println(msg1.startsWith("Array"));//�����Ƿ����
		System.out.println(msg1.endsWith(".java"));//��β�Ƿ����
		
	}

}
