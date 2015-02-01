package Thread2;
/*2013年5月21日16:37:39
 * 区别同步代码块与同步函数
 * 同步代码块无固定锁
 * 同步函数固定锁：this
 * */


class Ticket implements Runnable
{
	private static int num=100;
	public  boolean flag=true;
	Object ob=new Object();
	public  void run()
	{
	
		if(flag)
		{
			while(true)
			{ 	
			
					if(num>0)//(this)因为，是静态的，所以，是class字节码文件
						synchronized(Ticket.class){	
					{
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						System.out.println("买票者obj"+Thread.currentThread().getName()+"卖出数量"+num--);
						
					}
					}
			}
		}
		else
		{
			while(true)
			{ 	
				show();
			}
		}
	}
	public static synchronized void show()//(this)因为，是静态的，所以，是class字节码文件
	{
		if(num>0)
		{	
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("买票者"+Thread.currentThread().getName()+"卖出数量"+num--);
		}
	}

	
}

public class thread5{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ticket ti=new Ticket();
		
		Thread t=new Thread(ti);
		Thread t1=new Thread(ti);
	
		
		t.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//不加这个会快速打印余下代码块
		
		ti.flag=false;
		t1.start();
	

	}

}
