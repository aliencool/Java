package Thread1;
/*2013年5月14日15:25:17 学习线程调度
 * 1:getPriority setPriority 分别是获得线程的优先级 设置线程的优先级
 * 2:sleep 暂停当前的线程CPU使用让其他线程运行
 * 3:yied  暂停当前的线程CPU使用让和它同级或者比它高的线程的使用
 * 4:join  在当前线程(就是各个方法内)调用另一个线程.使得当前线程要在另一个线程执行完后才执行当前线程
 * */

public class thread2 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread th=Thread.currentThread();
		System.out.println(th.getPriority());
		
		thread1 th1=new thread1("1");
		thread1 th2=new thread1("2");
		System.out.println(th1.getPriority());//获得当前线程优先级，因为， 是MAIN线程算创建，所以，优先级与MAIN相同；
		System.out.println(th2.getPriority());//获得当前线程优先级，因为， 是MAIN线程算创建，所以，优先级与MAIN相同；
		
		th1.setPriority(Thread.MIN_PRIORITY);//设置优先级，来使得线程优先调用
		th2.setPriority(Thread.MAX_PRIORITY);//设置优先级，来使得线程优先调用
		System.out.println(th1.getPriority());//获得当前线程优先级，因为， 是MAIN线程算创建，所以，优先级与MAIN相同；
		System.out.println(th2.getPriority());//获得当前线程优先级，因为， 是MAIN线程算创建，所以，优先级与MAIN相同；
		
		th1.start();
		th1.join();
		System.out.println("test");
		

	}

}
