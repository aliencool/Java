package Thread6;

import java.util.concurrent.*;
/*2013��6��8��10:35:15
 * ��������
 * */
class Resourc
{
	boolean flag=true;
	ArrayBlockingQueue ab=new ArrayBlockingQueue(1);
	
	public void put()
	{
		
		
			
			try {
			Thread.sleep(1000);
			System.out.println("׼��������");
				ab.put(2);
				flag=false;
				System.out.println(Thread.currentThread().getName()+":�Ѿ�����"+ab.size()+"������");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	

	public void get()
	{
		Object i = null;
		
				
				try {
					Thread.sleep(1000);
					System.out.println("׼��ȡ����");
					i= ab.take();
					flag=true;
					System.out.println(Thread.currentThread().getName()+":�Ѿ�ȡ������"+i.toString()+"����������"+ab.size()+"������");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
		}
}
class Put implements Runnable
{
	private Resourc r;

	Put(Resourc r)
	{
		this.r=r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			r.put();
		}
	}
	
	
}
class Get implements Runnable
{
	private Resourc r;

	Get(Resourc r)
	{
		this.r=r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			r.get();
		}
	}
	
	
}
public class ArrayBlockingQueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService ec=Executors.newCachedThreadPool();
		Resourc re=new Resourc();
		Put put=new Put(re);
		Get get=new Get(re);
		ec.execute(put);
		ec.execute(get);
	
	}

}
