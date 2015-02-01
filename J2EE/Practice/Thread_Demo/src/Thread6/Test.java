package Thread6;
/*2013��6��5��22:38:24
 * ѭ������
 * */

import java.util.concurrent.locks.*;

class ThreadTest
{   /*������*/
	static int Count;//��ӡ1~10 ��1~100������־
	static boolean flag=false;//�����߳�ͨ��
	static int flag1=0;//���һ:�������߳�ѭ��50��
	static int flag2=0;//��Ƕ�:�������߳�ѭ��50��
	Lock lo=new ReentrantLock();
	Condition  isT=lo.newCondition();//����10�εļ�����
	Condition  isH=lo.newCondition();//����100�εļ�����
	/*������*/
	public void Sontest()//���߳�
	{
		lo.lock();
		try{
			while(flag)//����10�����������ͣ���߳�
			{
				isT.await();
			}
			Count=0;
			while(Count!=10)
			{
				++Count;
				System.out.println(Thread.currentThread().getName()+"���߳�"+"..........."+Count);
			}
			flag=true;//����Ƿ�ִ�д��߳�
			isH.signal();//����10�������������ѭ��100�ε��߳�
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally
		{
			lo.unlock();//�ͷ���
		}	
	}
	public void Fathertest()//���߳�
	{
		lo.lock();
		try{
			while(!flag)//����100�����������ͣ���߳�
			{
				isH.await();
			}
			Count=0;
			while(Count!=100)
			{
				++Count;
				System.out.println(Thread.currentThread().getName()+"...."+"���߳�"+"..........."+Count);
			}
			flag=false;//����Ƿ�ִ�д��߳�
			isT.signal();//����100�������������ѭ��10�ε��߳�
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			lo.unlock();//�ͷ���
		}
		
	}
		
}

class Ftest implements Runnable //��
{
	private ThreadTest tt;
	Ftest(ThreadTest tt)
	{
		this.tt=tt;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(ThreadTest.flag1++!=50)//ѭ��50
		{
			tt.Fathertest();
		}
	}
}
class Stest implements Runnable  //��
{
	private ThreadTest tt;
	Stest(ThreadTest tt)//ѭ��50
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
		
		
		ThreadTest tt=new ThreadTest();//��֤����ͬһ������
		Stest st=new Stest(tt);
		Ftest ft=new Ftest(tt);
		
		Thread t0=new Thread(st);
		Thread t1=new Thread(ft);
		
		
		t0.start();//����
		t1.start();	//����
			
	
		

	}

}
