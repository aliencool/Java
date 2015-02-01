package Thread6;

import java.util.concurrent.*;
/*2013年6月8日10:35:15
 * 阻塞队列
 * */
class Resourc
{
	boolean flag=true;
	ArrayBlockingQueue ab=new ArrayBlockingQueue(1);
	
	public void put()
	{
		
		
			
			try {
			Thread.sleep(1000);
			System.out.println("准备放数据");
				ab.put(2);
				flag=false;
				System.out.println(Thread.currentThread().getName()+":已经放了"+ab.size()+"个数据");
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
					System.out.println("准备取数据");
					i= ab.take();
					flag=true;
					System.out.println(Thread.currentThread().getName()+":已经取了数据"+i.toString()+"，还有数据"+ab.size()+"个数据");
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
