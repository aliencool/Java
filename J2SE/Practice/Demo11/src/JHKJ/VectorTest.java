package JHKJ;

import java.util.Enumeration;
import java.util.Vector;

/*2013年7月23日21:18:35
 * 学习Vector
 * 不建议使用!
 * 枚举是列举所有可能的取值
 * */
public class VectorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector ve=new Vector();
		ve.add("abc1");
		ve.add("abc2");
		
		Enumeration  en=ve.elements();
		while(en.hasMoreElements())
		{
			System.out.println(en.nextElement());
		}
	}

}
