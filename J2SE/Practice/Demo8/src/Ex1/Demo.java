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
			throw new NullPointerException("���鲻��Ϊ��");
		}
		if(index>=arr.length){
			throw new ArrayIndexOutOfBoundsException("����Խ��������...."+index);
		}
		if(index<0){
			throw new FushuIndexException("�Ǳ�Ϊ����");
		}
		
		
	}
}
