package Ex1;
class FushuIndexException extends RuntimeException
{
	
	FushuIndexException() 
	{
		
	}
	FushuIndexException(String msg) 
	{
		super(msg);
	}
}
class Demo
{
	public static void test(int []arr,int index) 
	{
		if(arr==null)
		{
			throw new NullPointerException("数组不能为空");
		}
		if(index>=arr.length){
			throw new ArrayIndexOutOfBoundsException("数组越界啦啦啦...."+index);
		}
		if(index<0){
			throw new FushuIndexException("角标为负数");
		}
		
		
	}
}
