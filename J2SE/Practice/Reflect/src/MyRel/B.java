package MyRel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*2013��10��25��21:03:05
 * ���캯��:
 * 		 1:Ҫ�Ȼ�ȡ���캯��
 * 		 2:�����б�
 * 		 3:newintance(����ʹ��)
 * */
public class B {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException //˽��
	 * @throws InstantiationException //������ƥ��
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		
		//���ؽ��ڴ棬����class1
		Class class1=Class.forName("MyTest.Person");
		
		//��ȡ���캯��
		//��ȡ����˽��
		Constructor constructor=class1.getConstructor(String.class,int.class);
		//��ȡȫ�� 
		//Constructor constructor1=class1.getDeclaredConstructor(String.class,int.class);
		//constructor1.setAccessible(true);
		//����
		Object object=constructor.newInstance("Сǿ",38);
		
		
		
		
		
		
	}

}
