package Thread6;
/*4个线程,2个线程对j+1,2个线程对j减一
 * 多线程通信
 * */
class Resource
{
	private boolean flag=false;
	private int j=0;
	
	public synchronized void add() 
	{
		while(flag)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"J++:"+j++);
		flag=true;
		notifyAll();
		
	}
	
	public synchronized void sub() 
	{
		while(!flag)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"J--:"+j--);
		flag=false;
		notifyAll();
		
	}

}

class AddThread implements Runnable
{
	private Resource r;

	AddThread(Resource r)
	{
		this.r=r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			r.add();
		}
	}
	
	
}

class SubThread implements Runnable
{
	private Resource r;

	SubThread(Resource r)
	{
		this.r=r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			r.sub();
		}
	}
	
	
}

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Resource r=new Resource();
		AddThread at=new AddThread(r);
		SubThread st=new SubThread(r);
		
		Thread t0=new Thread(at);
		Thread t1=new Thread(at);
		Thread t2=new Thread(st);
		Thread t3=new Thread(st);
		
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		
		
	}

}
