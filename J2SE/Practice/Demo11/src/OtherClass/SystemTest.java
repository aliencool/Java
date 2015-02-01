package OtherClass;
/*2013年8月8日17:34:14
 * 学习System 全是静态的
 * properties:各种获取(只有 Propertiers获取才有get)
 * SetProperty:设置属性
 * */
import java.util.*;

public class SystemTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello"+System.getProperty("os.version")+"World");
		
		
		System.setProperty("haha", "heihei");//自动设置属性
		System.out.println("Hello"+System.getProperty("haha")+"World");
		
		
		Properties pp=System.getProperties();
		Set<String> set=pp.stringPropertyNames();
		
		for(String key:set)
		{
			System.out.println(key+"::"+pp.getProperty(key));
		}
		
		
	}

}
