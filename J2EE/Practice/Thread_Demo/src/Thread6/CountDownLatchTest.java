package Thread6;
/*2013年6月7日22:02:37
 * 学习CountDownLatchTest倒计时:构造方法是倒计时个数
 * await()等待减完
 * countDown()减减
 * */
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {



	public static void main(String[] args) {
		ExecutorService ec=Executors.newCachedThreadPool();
		final CountDownLatch cdlOrder=new CountDownLatch(1);
		final CountDownLatch cdlAnswer=new CountDownLatch(3);
	
		for(int i=0;i<=2;i++)
		{	
			ec.execute(new Runnable()
			{

			@Override
			public void run() {
				try {
					cdlOrder.await();
					System.out.println("当前线程："+Thread.currentThread().getName()+"接受发送命令");
					System.out.println("当前线程："+Thread.currentThread().getName()+"处理结果");
					cdlAnswer.countDown();
				} catch (Exception e) {
					e.printStackTrace();
				}
		
			}}
			);
		}
		

		try {
			cdlOrder.countDown();
			System.out.println("当前线程："+Thread.currentThread().getName()+"已经使用发送命令");
			cdlAnswer.await();
			System.out.println("当前线程："+Thread.currentThread().getName()+"结果显示");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
