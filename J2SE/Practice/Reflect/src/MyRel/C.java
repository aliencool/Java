package MyRel;

import java.lang.reflect.Field;

/*2013��10��25��21:44:44
 * �ֶ�:
 * 		1:	getFiled(�ֶ���)
 * 			getDeclare(�ֶ���)
 * 		2:	���Ҫ����˽�е�ʱ�� ʹ��setAccessible
 * 		3:  ��Ϊ�����ǵ��ö���������Ƕ���.���ԣ����ԣ�Ҫ���ݶ���.
 * 			set(����ֵ)��ֵ
 * 			get(����):��ǰ�������õ�ֵ �з���ֵ
 * */
public class C {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws Exception 
	 * @throws SecurityException 
	 */
	public static void main(String[] args) throws  Exception {
		// TODO Auto-generated method stub
		//���ؽ��ڴ棬����class1
		Class class1=Class.forName("MyTest.Person");
		
		//��ȡ��������
		Field  filed=class1.getDeclaredField("age");
		filed.setAccessible(true);
		//����object���������
		Object object=class1.newInstance();
		
	
		
		//object��������
		filed.set(object, 88);
		
		
		//object���󷵻�
		Object object2=filed.get(object);
		
		System.out.println(object2);
		
	}

}
