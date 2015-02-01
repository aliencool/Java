package Thread1;
/*2013年5月13日15:55:12
 * 学习Run与Start区别:
 * Run表示线程的运行体（线程运动代码块），不会创造新的线程
 * Start表示创造新的线程和Main并发执行，并实现Run的方法
 * */

public class thread1 extends Thread{

	/**
	 * @param args
	 */
	private int a;
	thread1(String name)
	{
		super(name);
	}
	
	public void run()
	{
		for(a=0;a<50;a++){
			System.out.println(currentThread().getName()+":"+a);
			
		}
		try {
			sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		thread1 th=new thread1("1");
		thread1 th2=new thread1("2");

		th.start();
		
		System.out.println(th.isAlive());
		th2.start();
		

	}

}
