package MyRel;

import MyTest.Person;

/**
 * 2013��10��25��20:32:41
 * ѧϰ����
 * ���䣺�ǿ��Ի������ʱ����ķ��������캯�����ֶΣ����η�.
 * Class����Ҫ��:
 * 				���������ֽ���!
 * ��ȡ�ֽ����ļ����ַ�ʽ:
 *                   1:Class.forName(����+����):��Ϊ���
 *                   2:����.class:������ľ�̬class�ļ�
 *                   3:������.getclass():��Ҫ֪���ض��Ķ���
 * */
public class A {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		 three() ;
	}
	
	/*��һ�ַ�ʽ
	 *         �Ƚ��鷳����Ҫ֪���ض��Ķ���
	 * */
	public static void one()
	{
		Person p=new Person();
		Class<?> class1=p.getClass();
		
		Person  p1=new Person();
		Class<?> class2=p1.getClass();
		
		System.out.println(class1==class2);
		
	}
	
	/*�ڶ��ַ�ʽ:
	 *         �Ƚϼ�㣬���ǻ�����Ҫ֪�����������þ�̬��Ա
	 * */
	public static void two()
	{
		Class<?> class1=Person.class;
		System.out.println(class1);
		
	}

	/*�����ַ�ʽ:
	 * 			��Ϊ���ã�ֱ��ʹ��forName(����+����)���ɲ���
	 * */
	public static void three() throws ClassNotFoundException
	{
		Class<?> class1=Class.forName("MyTest.Person");
		System.out.println(class1);
	}
 }
