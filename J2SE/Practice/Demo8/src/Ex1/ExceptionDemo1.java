package Ex1;
/*2013年5月6日16:29:51
 * 学习throw
 * 如果栈中没有异常处理，他会不停的向上抛出异常，直到为JVM，后输出异常信息
 * 可以对原有的异常类进行自定义
 */


public class  ExceptionDemo1
{
	public static void main(String[] args)
	{
		int []arr=new int[3];
		Demo.test(arr, 5);
		
		
	}
	
}
