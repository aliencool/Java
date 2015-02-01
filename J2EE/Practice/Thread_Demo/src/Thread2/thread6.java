package Thread2;
/*2013年5月21日21:43:13
 * 死锁 
 * 线程一拿了locka并线程二拿了lockb,
 * 要执行lockb的时候发现线程二已经拿
 * 要执行locka的时候发现线程一已经拿
 * */
class Test implements Runnable
{

	private Object locka=new Object();
	private Object lockb=new Object();
	public  boolean flag;
	
	public Test(boolean flag)
	{
		this.flag=flag;
	}
	
	public void run()
	{
		if(flag)
		{
			while(true)
			synchronized(locka)
			{
				System.out.println(Thread.currentThread().getName()+"...."+"if .........locka");
				synchronized(lockb)
				{
					System.out.println(Thread.currentThread().getName()+"if .........lockb");
				}
				
			}
			
		}
		else
		{
			while(true)
			synchronized(lockb)
			{	
				System.out.println(Thread.currentThread().getName()+"else .........lockb");
				synchronized(locka)
				{
					System.out.println(Thread.currentThread().getName()+"if .........locka");
				}
				
			}
			
			
		}
		
	}

}
public class thread6 {
	
	
	public static void main(String[] args) {
		Test t1=new Test(true);
		Test t2=new Test(false);
		
		Thread th1=new Thread(t1);
		Thread th2=new Thread(t2);
		
		th1.start();
		th2.start();

	}
}
