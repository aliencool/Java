package Thread5;
/*2013年6月4日16:36:32
 * 线程中断方式
 * 1:标记,只能中断不是冻结状态
 * 2:Interupt:将冻结状态转为执行权
 * */
class StopThread implements Runnable
{
	private boolean flag=true;
	
	public void setFlag()
	{
		flag=false;
	}
	
	@Override
	public synchronized void run() {
		while(flag)
		{
			try {
				wait();//冻结状态时结束不了，应该使用interupt
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(Thread.currentThread().getName()+"........."+e);
				flag=false;
			}
			System.out.println(Thread.currentThread().getName()+"........."+"执行");
		}
		
	}
	

}

public class thread11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=0;
		
		StopThread st=new StopThread();		
		Thread t0=new Thread(st);
		Thread t1=new Thread(st);
		
		t0.start();

		t1.start();
		
		while(true)
		{
			if(++num==50){
			t0.interrupt();
			t1.interrupt();
			break;}
			System.out.println(Thread.currentThread().getName()+"........."+"执行");
		}
		
		System.out.println("over");
	}

}
