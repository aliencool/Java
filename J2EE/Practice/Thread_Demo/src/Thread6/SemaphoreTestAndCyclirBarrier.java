package Thread6;
/*2013年6月7日22:00:30
 * 学习Semaphore and CyclirBarrier
 * Semaphore 多个同步，只有，拿到才可以使用，没有拿到不可以等待!3个方法acquire(给予资格) availablePermits(已经执行) release(释放)
 * 
 * CyclirBarrier只有线程同时执行才可以进行! await
 * */
import java.util.concurrent.*;

public class SemaphoreTestAndCyclirBarrier {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		ExecutorService ec=Executors.newCachedThreadPool();
		final Semaphore sep=new Semaphore(3);//创建三个信号灯
		final CyclicBarrier cyc=new CyclicBarrier(3);
		for(int i=0;i<=9;i++)
		{	
			ec.execute(new Runnable()
			{

			@Override
			public void run() {
				 try {
					sep.acquire();//是否获得同步 是则执行下面
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("当前线程："+Thread.currentThread().getName()+"当前已经使用："+(3-sep.availablePermits()));
				sep.release();
		
			}}
			);
		}
		//线程同时到达后继续前进
		for(int i=0;i<=2;i++)
		{	
			ec.execute(new Runnable()  
			{

			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("当前线程："+Thread.currentThread().getName()+"已经到达目的1:"+cyc.getNumberWaiting());
					
						try {
							cyc.await();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (BrokenBarrierException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					System.out.println("当前线程："+Thread.currentThread().getName()+"已经到达目的2:"+cyc.getNumberWaiting());
					
						try {
							cyc.await();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (BrokenBarrierException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
						
			}}
			);
		}

	}

}
