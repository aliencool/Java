package Thread6;
/*2013年6月5日22:38:24
 * 循环调度
 * */

import java.util.concurrent.locks.*;

class ThreadTest
{   /*定义区*/
	static int Count;//打印1~10 与1~100计数标志
	static boolean flag=false;//用于线程通信
	static int flag1=0;//标记一:用于主线程循环50次
	static int flag2=0;//标记二:用于子线程循环50次
	Lock lo=new ReentrantLock();
	Condition  isT=lo.newCondition();//满足10次的监视器
	Condition  isH=lo.newCondition();//满足100次的监视器
	/*方法区*/
	public void Sontest()//子线程
	{
		lo.lock();
		try{
			while(flag)//满足10次则监视器暂停此线程
			{
				isT.await();
			}
			Count=0;
			while(Count!=10)
			{
				++Count;
				System.out.println(Thread.currentThread().getName()+"子线程"+"..........."+Count);
			}
			flag=true;//标记是否执行此线程
			isH.signal();//满足10次则监视器激活循环100次的线程
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally
		{
			lo.unlock();//释放锁
		}	
	}
	public void Fathertest()//主线程
	{
		lo.lock();
		try{
			while(!flag)//满足100次则监视器暂停此线程
			{
				isH.await();
			}
			Count=0;
			while(Count!=100)
			{
				++Count;
				System.out.println(Thread.currentThread().getName()+"...."+"主线程"+"..........."+Count);
			}
			flag=false;//标记是否执行此线程
			isT.signal();//满足100次则监视器激活循环10次的线程
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			lo.unlock();//释放锁
		}
		
	}
		
}

class Ftest implements Runnable //主
{
	private ThreadTest tt;
	Ftest(ThreadTest tt)
	{
		this.tt=tt;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(ThreadTest.flag1++!=50)//循环50
		{
			tt.Fathertest();
		}
	}
}
class Stest implements Runnable  //子
{
	private ThreadTest tt;
	Stest(ThreadTest tt)//循环50
	{
		this.tt=tt;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(ThreadTest.flag2++!=50)
		{
			tt.Sontest();
		}
	}
	
}


public class Test  {
	public static void main(String[] args) {
		
		
		ThreadTest tt=new ThreadTest();//保证共享同一个对象
		Stest st=new Stest(tt);
		Ftest ft=new Ftest(tt);
		
		Thread t0=new Thread(st);
		Thread t1=new Thread(ft);
		
		
		t0.start();//启动
		t1.start();	//启动
			
	
		

	}

}
