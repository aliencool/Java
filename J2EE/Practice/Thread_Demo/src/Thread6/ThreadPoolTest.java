package Thread6;

import java.util.concurrent.*;


/*2013��6��6��22:58:47
 * ѧϰ�̳߳�
 * �̳߳�:�����񶪽��̳߳أ��̳߳�ѡȡ����ִ�У�ִ����ɺ��ٻص��̳߳أ��ȴ��´�����
 * Fixed���̶��̳߳�
 * Catched:�Զ������̳߳�
 * Single:�����̳߳أ��߳����˺�Ѱ����һ���̲߳��ϣ�
 * 
 * Scedule(��һ����ִ�е�����,�ڶ���:ÿ������,��������˵��ÿ��������ʲô��λ);
 * SceduleAtFixedRate((��һ����ִ�е�����,�ڶ������ظ�ִ�ж��ٴ�,�ڶ�����ÿ������,��������˵��ÿ��������ʲô��λ);)
 * */
public class ThreadPoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ExecutorService es=Executors.newFixedThreadPool(5);�̶�
		ExecutorService es=Executors.newCachedThreadPool();//�Զ��仯��
		//ExecutorService es=Executors.newSingleThreadExecutor();
		for(int i=1;i<=10;i++){
			final int task=i;
			es.execute(new Runnable()
			{
				public void run() {
					for(int j=1;j<=10;j++)
					{
						System.out.println(Thread.currentThread().getName()+"   "+"��"+task+"������"+"��ӡ:"+j);
					}
				}}
			);
		
		}
		es.shutdown();
		
		Executors.newScheduledThreadPool(5).scheduleAtFixedRate(new Runnable(){//ʱ�����

			@Override
			public void run() {
				System.out.println("Bombing");
				
			}}, 10, 2,TimeUnit.SECONDS);
	
		
	}

}
