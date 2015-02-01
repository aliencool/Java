package Ex2;/*
2013年5月7日15:07:10
try........catch
1:能处理就捕捉
2:try 是检测 catch(捕捉){处理}
3:e的问题:e输出的信息 printstatck是默认的输出语句
4:多个异常就有多catch!
*/
class IndexException extends Exception
{
	
	IndexException() 
	{
		
	}
	IndexException(String msg) 
	{
		super(msg);
	}
}
class DEMO
{
	public  void test(int []arr,int index) throws IndexException,NullPointerException
	{
		if(arr==null)
		{
			throw new NullPointerException("数组不能为空");
		}
		if(index<0)
			
		{
			throw new IndexException("负数角标不合法");
		}
		
		
		
	}
}

public class ExceptionDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr=new int[3];
		DEMO d=new DEMO();
		try{d.test(null, -6);}
		catch(IndexException e){
			e.printStackTrace();
			System.out.println(e); }
		catch(NullPointerException e){
			e.printStackTrace();
			System.out.println(e); }
	}

}
