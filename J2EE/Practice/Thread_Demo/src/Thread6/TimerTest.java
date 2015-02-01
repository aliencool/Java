package Thread6;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	
	
	static class MyTimerTask extends TimerTask
	{
		
		@Override
		public void run() {
			
			System.out.println("Bombing....");
			new Timer().schedule(new MyTimerTask1(), 2000);
			
		}
	
	}
	
	 static	class MyTimerTask1 extends TimerTask
	{
		
		@Override
		public void run() {
			
			System.out.println("Bombing....");
			new Timer().schedule(new MyTimerTask(), 4000);
			
		}
	
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
	

		new Timer().schedule(new MyTimerTask(), 2000);
		
		
		
		while(true)
		{
			System.out.println(new Date().getSeconds());
			Thread.sleep(1000);
		}
		
}
}
