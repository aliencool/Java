package Thread1;
/*2013��5��21��15:37:00
 * ѧϰͬ������
 * ֻ��Ҫ��Synchronized������η�����
 * */

class Bank
{
	private int sum=0;
	public synchronized void add(int num)
	{		
		
			sum=sum+num;
			System.out.println("�����"+Thread.currentThread().getName()+"�������"+sum);
		
	}

}

class customs implements Runnable
{

	Bank b=new Bank();
	public void run() {
		// TODO Auto-generated method stub
		//Bank b=new Bank();�ŵ������ж���߳�ִ�� 
		for(int i=0;i<3;i++)
		{
			b.add(100);
		}
	}
	

}
public class thread4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		customs cu=new customs();
		Thread th=new Thread(cu);
		Thread th1=new Thread(cu);
		
		th.start();
		th1.start();

	}

}
