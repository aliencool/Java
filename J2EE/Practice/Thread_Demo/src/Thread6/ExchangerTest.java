package Thread6;
/*2013年6月8日10:18:14
 * Exchanger:是两个线程资源交换；
 * 当一个线程还没有到达的时候，另一个线程等待，到达后同时进行交换!
 * */
import java.util.concurrent.*;

public class ExchangerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService ec=Executors.newCachedThreadPool();
		final Exchanger exc=new Exchanger();
		
		ec.execute(new Runnable()
		{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String msg="haha";
				try {
					System.out.println(Thread.currentThread().getName()+"未交换:"+msg);
					String message=(String) exc.exchange(msg);//等着线程2到来交换
					System.out.println(Thread.currentThread().getName()+":"+message);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}}
		);
		
		ec.execute(new Runnable()
		{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String msg="heihei";
				try {
					System.out.println(Thread.currentThread().getName()+"未交换:"+msg);
					String message=(String) exc.exchange(msg);//等着线程2到来交换
					System.out.println(Thread.currentThread().getName()+":"+message);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}}
		);
		
	}

}
