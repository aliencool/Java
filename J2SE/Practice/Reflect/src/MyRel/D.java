package MyRel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;;

/*2013年10月25日22:19:02
 * 		方法:
 * 		   1:设置调用的方法名和参数
 * 			 getMethod();
 * 			 getDeclareMethod();//获取私有的 要执行则使用setAccessible
 * 		   2:设置你要调用的对象
 * 		   3:
 * 		   4:执行 对象，参数(真正的参数)
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
		
	/*	Method[] method=class1.getMethods();//获得所有
		for(Method methods:method)
		{
			System.out.println(methods);
			
		}
		System.out.println();
		*/
		Method[] method=class1.getDeclaredMethods();		//获得当前的
		for(Method methods:method)
		{	
			System.out.println(methods);
			 Class<?>[] clazzParameterType = methods.getParameterTypes(); 
			System.out.println(clazzParameterType);
		}	
	}

	private static void two() throws Exception {
		// TODO Auto-generated method stub
		//加载进内存，生成class1
		Class class1=Class.forName("MyTest.Person");
		
		//获取方法 指定方法名和参数(为空就是null)
		Method method=class1.getMethod("paramMethod", String.class,int.class);
		
		//哪个对象调用
		Object obj=class1.newInstance();
		
		//执行
		method.invoke(obj, "x",38);
	
	}

	public static void one() throws Exception {
		//加载进内存，生成class1
		Class class1=Class.forName("MyTest.Person");
		
		//获取方法 指定方法名和参数(为空就是null)
		Method method=class1.getDeclaredMethod("privateMethod", null);
		method.setAccessible(true);
		//哪个对象调用方法的呢?
		Constructor constructor=class1.getConstructor(String.class,int.class);
		Object obj=constructor.newInstance("小强",38);
	
		//执行
		method.invoke(obj, null);
	
		
	}

}
