package Thread4;
/*2013年6月3日10:17:07
 * 等待-唤醒 多生产者多消费者
 * while 是唤醒后进行判断能不能执行
 * notifyAll 是保证解决死锁的问题(唤醒对方)
 * */

class Resource
{
	String name;
	int count=0;
	boolean flag=false;
	public synchronized void setName(String s)
	{
		while(flag)//产生死锁   解决办法是全部唤醒!! 唤醒 to --唤醒 t1 睡觉
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
			name=s+count;
			count++;
			System.out.println(Thread.currentThread().getName()+"...生产..."+name);
			flag=true;
			notifyAll();
		
	}
	
	public synchronized void Out()
	{
		while(!flag)//产生死锁 解决办法是全部唤醒 解决办法是全部唤醒!! 唤醒 t2 --唤醒 t3 睡觉
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
			System.out.println(Thread.currentThread().getName()+"...消费..."+name);
			flag=false;
			notifyAll();
		
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

public class thread9 {

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
