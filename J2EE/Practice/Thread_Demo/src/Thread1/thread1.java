package Thread1;
/*2013��5��13��15:55:12
 * ѧϰRun��Start����:
 * Run��ʾ�̵߳������壨�߳��˶�����飩�����ᴴ���µ��߳�
 * Start��ʾ�����µ��̺߳�Main����ִ�У���ʵ��Run�ķ���
 * */

public class thread1 extends Thread{

	/**
	 * @param args
	 */
	private int a;
	thread1(String name)
	{
		super(name);
	}
	
	public void run()
	{
		for(a=0;a<50;a++){
			System.out.println(currentThread().getName()+":"+a);
			
		}
		try {
			sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		thread1 th=new thread1("1");
		thread1 th2=new thread1("2");

		th.start();
		
		System.out.println(th.isAlive());
		th2.start();
		

	}

}
