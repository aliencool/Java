package JHKJ;

import java.util.Enumeration;
import java.util.Vector;

/*2013��7��23��21:18:35
 * ѧϰVector
 * ������ʹ��!
 * ö�����о����п��ܵ�ȡֵ
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
