package Test;

import java.util.Timer;
import java.util.TimerTask;

public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest1 t1=new ThreadTest1();
		ThreadTest2 t2=new ThreadTest2();
		t1.start();
		t2.start();
		
	}

}

class ThreadTest1  extends Thread{
	
	public void run() {
		while(true)
		{
			try {
				Thread.sleep(1000);
				System.out.println("Hello world");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
	}
}

class ThreadTest2  extends Thread{
	
	public void run() {
		while(true)
		{
			try {
				Thread.sleep(100);
				System.out.println("ooooooo");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
	}
}
