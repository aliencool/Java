package Thread6;
/*2013��6��8��10:18:14
 * Exchanger:�������߳���Դ������
 * ��һ���̻߳�û�е����ʱ����һ���̵߳ȴ��������ͬʱ���н���!
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
					System.out.println(Thread.currentThread().getName()+"δ����:"+msg);
					String message=(String) exc.exchange(msg);//�����߳�2��������
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
					System.out.println(Thread.currentThread().getName()+"δ����:"+msg);
					String message=(String) exc.exchange(msg);//�����߳�2��������
					System.out.println(Thread.currentThread().getName()+":"+message);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}}
		);
		
	}

}
