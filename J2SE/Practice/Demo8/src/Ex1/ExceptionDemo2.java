package Ex1;
/*2013年5月6日16:33:47
 * 自定义异常
 * RuntimeException是不用throws抛出来，因为，它是在运行的时候才发现错误
 * Exception是在编译的时候就必须检测的异常
 * */

public class  ExceptionDemo2
{
	public static void main(String[] args) 
	{
		int []arr=new int[3];
		Demo.test(arr, -6);
		
		
	}
	
}


