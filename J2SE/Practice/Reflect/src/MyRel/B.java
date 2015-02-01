package MyRel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*2013年10月25日21:03:05
 * 构造函数:
 * 		 1:要先获取构造函数
 * 		 2:参数列表
 * 		 3:newintance(传参使用)
 * */
public class B {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException //私有
	 * @throws InstantiationException //参数不匹配
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		
		//加载进内存，生成class1
		Class class1=Class.forName("MyTest.Person");
		
		//获取构造函数
		//获取不是私有
		Constructor constructor=class1.getConstructor(String.class,int.class);
		//获取全部 
		//Constructor constructor1=class1.getDeclaredConstructor(String.class,int.class);
		//constructor1.setAccessible(true);
		//运行
		Object object=constructor.newInstance("小强",38);
		
		
		
		
		
		
	}

}
