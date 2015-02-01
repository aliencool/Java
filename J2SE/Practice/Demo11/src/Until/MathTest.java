package Until;

import java.util.Random;

/*2013Äê8ÔÂ8ÈÕ21:13:49
 * 
 * */
public class MathTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Math.ceil(12.1));
		System.out.println(Math.floor(12.1));
		System.out.println(Math.round(12.1));
		System.out.println(Math.pow(10, 3));
		
		Random r=new Random();
		for(int i=0;i<10;i++)
		{
			double b=Math.random()*10;
			System.out.println(Math.ceil(b));
			System.out.println(Math.floor(b));
			System.out.println(r.nextInt(6));
		}
	}

}
