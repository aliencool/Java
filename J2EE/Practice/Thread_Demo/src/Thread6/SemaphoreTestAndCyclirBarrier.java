package Thread6;
/*2013��6��7��22:00:30
 * ѧϰSemaphore and CyclirBarrier
 * Semaphore ���ͬ����ֻ�У��õ��ſ���ʹ�ã�û���õ������Եȴ�!3������acquire(�����ʸ�) availablePermits(�Ѿ�ִ��) release(�ͷ�)
 * 
 * CyclirBarrierֻ���߳�ͬʱִ�вſ��Խ���! await
 * */
import java.util.concurrent.*;

public class SemaphoreTestAndCyclirBarrier {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		ExecutorService ec=Executors.newCachedThreadPool();
		final Semaphore sep=new Semaphore(3);//���������źŵ�
		final CyclicBarrier cyc=new CyclicBarrier(3);
		for(int i=0;i<=9;i++)
		{	
			ec.execute(new Runnable()
			{

			@Override
			public void run() {
				 try {
					sep.acquire();//�Ƿ���ͬ�� ����ִ������
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"��ǰ�Ѿ�ʹ�ã�"+(3-sep.availablePermits()));
				sep.release();
		
			}}
			);
		}
		//�߳�ͬʱ��������ǰ��
		for(int i=0;i<=2;i++)
		{	
			ec.execute(new Runnable()  
			{

			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"�Ѿ�����Ŀ��1:"+cyc.getNumberWaiting());
					
						try {
							cyc.await();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (BrokenBarrierException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"�Ѿ�����Ŀ��2:"+cyc.getNumberWaiting());
					
						try {
							cyc.await();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (BrokenBarrierException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
						
			}}
			);
		}

	}

}
