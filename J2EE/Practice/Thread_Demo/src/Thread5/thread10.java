package Thread5;

import java.util.concurrent.locks.*;

/*2013年6月3日17:27:38
 * 学习 lock condition
 * 一个锁挂多个监视器
 * 记得要加上lock()与finally
 * */
class Resource
{
	String name;
	int count=0;
	boolean flag=false;
	Lock lo=new ReentrantLock();
	Condition Scx_con=lo.newCondition();
	Condition Xfx_con=lo.newCondition();
	public  void setName(String s)
	{
		lo.lock();
		try{
		while(flag)//产生死锁   解决办法是全部唤醒!! 唤醒 to --唤醒 t1 睡觉
		{
			try {
				Scx_con.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
			name=s+count;
			count++;
			System.out.println(Thread.currentThread().getName()+"...生产..."+name);
			flag=true;
			Xfx_con.signal();
		}
		finally{
			lo.unlock();
		}
		
	}
	
	public synchronized void Out()
	{	
		lo.lock();
		try{
			while(!flag)//产生死锁 解决办法是全部唤醒 解决办法是全部唤醒!! 唤醒 t2 --唤醒 t3 睡觉
			{
				try {
					Xfx_con.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
				System.out.println(Thread.currentThread().getName()+"...消费..."+name);
				flag=false;
				Scx_con.signal();
		}
		finally{
			lo.unlock();
		}
	}
}

class Scz implements Runnable
{
	private Resource r;
	Scz(Resource r)
	{
		this.r=r;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
			while(true)
			{
				r.setName("烤鸭");
			}
	}	

}

class Xfz implements Runnable
{
	private Resource r;
	Xfz(Resource r)
	{
		this.r=r;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
			while(true)
			{
				r.Out();
			}
	}	

}

public class thread10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource r=new Resource();
		Scz scz=new Scz(r);
		Xfz xfz=new Xfz(r);
		
		Thread t0=new Thread(scz);
		Thread t1=new Thread(scz);
		Thread t2=new Thread(xfz);
		Thread t3=new Thread(xfz);
		
		t0.start();
		t1.start();
		t2.start();
		t3.start();

	}

}
