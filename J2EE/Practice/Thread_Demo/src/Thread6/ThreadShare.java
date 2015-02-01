package Thread6;

import java.util.*;

/*2013年6月6日11:08:08
 * 学习不同线程不同共享数据
 * */
public class ThreadShare {

	/**
	 * @param args
	 */
	private static Map<Thread,Integer> hasmp=new HashMap<Thread,Integer>();
	private static int data=0;/*不适用Hash则会造成数据不能独立*/
	
	public static void main(String[] args) {
	
		for(int i=0;i<2;i++)
		{   
		
			new Thread(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub	
					/*不适用Hash则会造成数据不能独立*/
					//data=new Random().nextInt();
					//new A().Ashow();
					//new B().Bshow();
					
					int data=new Random().nextInt();
					hasmp.put(Thread.currentThread(), data);
					new A().Ashow();
					new B().Bshow();
					
				}
				
			}).start();
			
		}

	}
	
static	class A
	{
		public void Ashow()
		{
			int data=hasmp.get(Thread.currentThread());
			System.out.println(Thread.currentThread().getName()+"........."+"A"+"..........."+data);
			//System.out.println(Thread.currentThread().getName()+"........."+"A"+"..........."+data);
		}
	}
	
static	class B
	{
		public void Bshow()
		{
			int data=hasmp.get(Thread.currentThread());
			System.out.println(Thread.currentThread().getName()+"........."+"B"+"..........."+data);
			//System.out.println(Thread.currentThread().getName()+"........."+"B"+"..........."+data);
		}
	}

}
