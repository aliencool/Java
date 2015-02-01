package Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadT1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ticket tc=new Ticket();
		Thread t1=new Thread(tc);
		
		Thread t2=new Thread(tc);
		Thread t3=new Thread(tc);
		
		t1.start();
		t2.start();
		t3.start();
	}

}


class Ticket implements Runnable
{
	Lock lo=new ReentrantLock();
	
	int Ticket_count=20;
	@Override
	public void run() {
		try {
			Sell();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void Sell() throws InterruptedException {
		while(true){
			lo.lock();
			Thread.sleep(500);
		   if(Ticket_count>0)
		   {
			   System.out.println(Thread.currentThread().getName()+"ÊÛ³ö"+Ticket_count);
			   Ticket_count--;
		   }
		   else
		   {
			   break;
		   }
			lo.unlock();  
		} 
		}
	}
	
