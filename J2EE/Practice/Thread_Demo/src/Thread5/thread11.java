package Thread5;
/*2013��6��4��16:36:32
 * �߳��жϷ�ʽ
 * 1:���,ֻ���жϲ��Ƕ���״̬
 * 2:Interupt:������״̬תΪִ��Ȩ
 * */
class StopThread implements Runnable
{
	private boolean flag=true;
	
	public void setFlag()
	{
		flag=false;
	}
	
	@Override
	public synchronized void run() {
		while(flag)
		{
			try {
				wait();//����״̬ʱ�������ˣ�Ӧ��ʹ��interupt
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(Thread.currentThread().getName()+"........."+e);
				flag=false;
			}
			System.out.println(Thread.currentThread().getName()+"........."+"ִ��");
		}
		
	}
	

}

public class thread11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=0;
		
		StopThread st=new StopThread();		
		Thread t0=new Thread(st);
		Thread t1=new Thread(st);
		
		t0.start();

		t1.start();
		
		while(true)
		{
			if(++num==50){
			t0.interrupt();
			t1.interrupt();
			break;}
			System.out.println(Thread.currentThread().getName()+"........."+"ִ��");
		}
		
		System.out.println("over");
	}

}
