package nb;
/*2013年4月26日16:03:21
 * 局部类:方法里面定义的类
 * 1:只能使用默认修饰符
 * 2:用final（形参）与顶层类给予赋值
 * 3:不能使用static
 * */

class Cat
{ int b;
	public void  Eat(final int a,int c)
	{
	 	class Q{
			int c=a;
			int d=b;
			
		}
		
	}

}

public class test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
