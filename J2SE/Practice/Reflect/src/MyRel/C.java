package MyRel;

import java.lang.reflect.Field;

/*2013年10月25日21:44:44
 * 字段:
 * 		1:	getFiled(字段名)
 * 			getDeclare(字段名)
 * 		2:	如果要访问私有的时候 使用setAccessible
 * 		3:  因为，我们调用对像的属性是对象.属性，所以，要传递对象.
 * 			set(对象，值)的值
 * 			get(对象):当前对象设置的值 有返回值
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
		//加载进内存，生成class1
		Class class1=Class.forName("MyTest.Person");
		
		//获取对象属性
		Field  filed=class1.getDeclaredField("age");
		filed.setAccessible(true);
		//设置object对象的属性
		Object object=class1.newInstance();
		
	
		
		//object对象设置
		filed.set(object, 88);
		
		
		//object对象返回
		Object object2=filed.get(object);
		
		System.out.println(object2);
		
	}

}
