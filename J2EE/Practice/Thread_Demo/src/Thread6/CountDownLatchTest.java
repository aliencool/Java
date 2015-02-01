package Thread6;
/*2013��6��7��22:02:37
 * ѧϰCountDownLatchTest����ʱ:���췽���ǵ���ʱ����
 * await()�ȴ�����
 * countDown()����
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
					System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"���ܷ�������");
					System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"������");
					cdlAnswer.countDown();
				} catch (Exception e) {
					e.printStackTrace();
				}
		
			}}
			);
		}
		

		try {
			cdlOrder.countDown();
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"�Ѿ�ʹ�÷�������");
			cdlAnswer.await();
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"�����ʾ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
