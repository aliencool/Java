package Ex2;/*
2013��5��7��15:07:10
try........catch
1:�ܴ���Ͳ�׽
2:try �Ǽ�� catch(��׽){����}
3:e������:e�������Ϣ printstatck��Ĭ�ϵ�������
4:����쳣���ж�catch!
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
			throw new NullPointerException("���鲻��Ϊ��");
		}
		if(index<0)
			
		{
			throw new IndexException("�����Ǳ겻�Ϸ�");
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
