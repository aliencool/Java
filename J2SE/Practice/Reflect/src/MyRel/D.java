package MyRel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;;

/*2013��10��25��22:19:02
 * 		����:
 * 		   1:���õ��õķ������Ͳ���
 * 			 getMethod();
 * 			 getDeclareMethod();//��ȡ˽�е� Ҫִ����ʹ��setAccessible
 * 		   2:������Ҫ���õĶ���
 * 		   3:
 * 		   4:ִ�� ���󣬲���(�����Ĳ���)
 * 
 * 
 * */
public class D {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		three();
	}

	private static void three() throws Exception {
		// TODO Auto-generated method stub
		Class class1=Class.forName("MyTest.Person");
		
	/*	Method[] method=class1.getMethods();//�������
		for(Method methods:method)
		{
			System.out.println(methods);
			
		}
		System.out.println();
		*/
		Method[] method=class1.getDeclaredMethods();		//��õ�ǰ��
		for(Method methods:method)
		{	
			System.out.println(methods);
			 Class<?>[] clazzParameterType = methods.getParameterTypes(); 
			System.out.println(clazzParameterType);
		}	
	}

	private static void two() throws Exception {
		// TODO Auto-generated method stub
		//���ؽ��ڴ棬����class1
		Class class1=Class.forName("MyTest.Person");
		
		//��ȡ���� ָ���������Ͳ���(Ϊ�վ���null)
		Method method=class1.getMethod("paramMethod", String.class,int.class);
		
		//�ĸ��������
		Object obj=class1.newInstance();
		
		//ִ��
		method.invoke(obj, "x",38);
	
	}

	public static void one() throws Exception {
		//���ؽ��ڴ棬����class1
		Class class1=Class.forName("MyTest.Person");
		
		//��ȡ���� ָ���������Ͳ���(Ϊ�վ���null)
		Method method=class1.getDeclaredMethod("privateMethod", null);
		method.setAccessible(true);
		//�ĸ�������÷�������?
		Constructor constructor=class1.getConstructor(String.class,int.class);
		Object obj=constructor.newInstance("Сǿ",38);
	
		//ִ��
		method.invoke(obj, null);
	
		
	}

}
