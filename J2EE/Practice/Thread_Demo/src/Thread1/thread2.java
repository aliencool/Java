package Thread1;
/*2013��5��14��15:25:17 ѧϰ�̵߳���
 * 1:getPriority setPriority �ֱ��ǻ���̵߳����ȼ� �����̵߳����ȼ�
 * 2:sleep ��ͣ��ǰ���߳�CPUʹ���������߳�����
 * 3:yied  ��ͣ��ǰ���߳�CPUʹ���ú���ͬ�����߱����ߵ��̵߳�ʹ��
 * 4:join  �ڵ�ǰ�߳�(���Ǹ���������)������һ���߳�.ʹ�õ�ǰ�߳�Ҫ����һ���߳�ִ������ִ�е�ǰ�߳�
 * */

public class thread2 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread th=Thread.currentThread();
		System.out.println(th.getPriority());
		
		thread1 th1=new thread1("1");
		thread1 th2=new thread1("2");
		System.out.println(th1.getPriority());//��õ�ǰ�߳����ȼ�����Ϊ�� ��MAIN�߳��㴴�������ԣ����ȼ���MAIN��ͬ��
		System.out.println(th2.getPriority());//��õ�ǰ�߳����ȼ�����Ϊ�� ��MAIN�߳��㴴�������ԣ����ȼ���MAIN��ͬ��
		
		th1.setPriority(Thread.MIN_PRIORITY);//�������ȼ�����ʹ���߳����ȵ���
		th2.setPriority(Thread.MAX_PRIORITY);//�������ȼ�����ʹ���߳����ȵ���
		System.out.println(th1.getPriority());//��õ�ǰ�߳����ȼ�����Ϊ�� ��MAIN�߳��㴴�������ԣ����ȼ���MAIN��ͬ��
		System.out.println(th2.getPriority());//��õ�ǰ�߳����ȼ�����Ϊ�� ��MAIN�߳��㴴�������ԣ����ȼ���MAIN��ͬ��
		
		th1.start();
		th1.join();
		System.out.println("test");
		

	}

}
