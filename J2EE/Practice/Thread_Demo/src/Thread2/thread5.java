package Thread2;
/*2013��5��21��16:37:39
 * ����ͬ���������ͬ������
 * ͬ��������޹̶���
 * ͬ�������̶�����this
 * */


class Ticket implements Runnable
{
	private static int num=100;
	public  boolean flag=true;
	Object ob=new Object();
	public  void run()
	{
	
		if(flag)
		{
			while(true)
			{ 	
			
					if(num>0)//(this)��Ϊ���Ǿ�̬�ģ����ԣ���class�ֽ����ļ�
						synchronized(Ticket.class){	
					{
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						System.out.println("��Ʊ��obj"+Thread.currentThread().getName()+"��������"+num--);
						
					}
					}
			}
		}
		else
		{
			while(true)
			{ 	
				show();
			}
		}
	}
	public static synchronized void show()//(this)��Ϊ���Ǿ�̬�ģ����ԣ���class�ֽ����ļ�
	{
		if(num>0)
		{	
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("��Ʊ��"+Thread.currentThread().getName()+"��������"+num--);
		}
	}

	
}

public class thread5{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ticket ti=new Ticket();
		
		Thread t=new Thread(ti);
		Thread t1=new Thread(ti);
	
		
		t.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//�����������ٴ�ӡ���´����
		
		ti.flag=false;
		t1.start();
	

	}

}
