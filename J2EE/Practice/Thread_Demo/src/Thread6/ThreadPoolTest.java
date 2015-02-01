package Thread6;

import java.util.concurrent.*;


/*2013年6月6日22:58:47
 * 学习线程池
 * 线程池:把任务丢进线程池，线程池选取任务执行，执行完成后再回到线程池，等待下次任务
 * Fixed：固定线程池
 * Catched:自动增加线程池
 * Single:单独线程池（线程死了后，寻找另一个线程补上）
 * 
 * Scedule(第一个：执行的任务,第二个:每隔多少,第三个：说明每隔多少是什么单位);
 * SceduleAtFixedRate((第一个：执行的任务,第二个：重复执行多少次,第二个：每隔多少,第三个：说明每隔多少是什么单位);)
 * */
public class ThreadPoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ExecutorService es=Executors.newFixedThreadPool(5);固定
		ExecutorService es=Executors.newCachedThreadPool();//自动变化的
		//ExecutorService es=Executors.newSingleThreadExecutor();
		for(int i=1;i<=10;i++){
			final int task=i;
			es.execute(new Runnable()
			{
				public void run() {
					for(int j=1;j<=10;j++)
					{
						System.out.println(Thread.currentThread().getName()+"   "+"第"+task+"个任务"+"打印:"+j);
					}
				}}
			);
		
		}
		es.shutdown();
		
		Executors.newScheduledThreadPool(5).scheduleAtFixedRate(new Runnable(){//时间调度

			@Override
			public void run() {
				System.out.println("Bombing");
				
			}}, 10, 2,TimeUnit.SECONDS);
	
		
	}

}
