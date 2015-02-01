package MyRel;

import MyTest.Person;

/**
 * 2013年10月25日20:32:41
 * 学习反射
 * 反射：是可以获得运行时的类的方法，构造函数，字段，修饰符.
 * Class类主要是:
 * 				描述所有字节码!
 * 获取字节码文件三种方式:
 *                   1:Class.forName(包名+类名):最为简便
 *                   2:类名.class:调用类的静态class文件
 *                   3:对象名.getclass():需要知道特定的对象
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
	
	/*第一种方式
	 *         比较麻烦，需要知道特定的对象
	 * */
	public static void one()
	{
		Person p=new Person();
		Class<?> class1=p.getClass();
		
		Person  p1=new Person();
		Class<?> class2=p1.getClass();
		
		System.out.println(class1==class2);
		
	}
	
	/*第二种方式:
	 *         比较简便，但是还是需要知道类名来调用静态成员
	 * */
	public static void two()
	{
		Class<?> class1=Person.class;
		System.out.println(class1);
		
	}

	/*第三种方式:
	 * 			最为常用，直接使用forName(包名+类名)即可查找
	 * */
	public static void three() throws ClassNotFoundException
	{
		Class<?> class1=Class.forName("MyTest.Person");
		System.out.println(class1);
	}
 }
