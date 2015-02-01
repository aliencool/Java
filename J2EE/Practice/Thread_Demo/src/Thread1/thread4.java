package Thread1;
/*2013年5月21日15:37:00
 * 学习同步函数
 * 只需要把Synchronized变成修饰符即可
 * */

class Bank
{
	private int sum=0;
	public synchronized void add(int num)
	{		
		
			sum=sum+num;
			System.out.println("存款者"+Thread.currentThread().getName()+"存款数量"+sum);
		
	}

}

class customs implements Runnable
{

	Bank b=new Bank();
	public void run() {
		// TODO Auto-generated method stub
		//Bank b=new Bank();放到这里有多个线程执行 
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
