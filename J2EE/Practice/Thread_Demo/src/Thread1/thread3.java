/*2013��5��18��15:16:21
 * ͬ�������
 * */
package Thread1;
class Ticket implements Runnable
{
	private int num=100;
	private int i=0;
	public void sales()
	{
		while(i<100)
		{ 
			synchronized(this){
			if(num>0)
			{	
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("��Ʊ��"+Thread.currentThread().getName()+"��������"+num);
				--num;
			}
			}
			i++;
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		sales();
		
	}
	
}

public class thread3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ticket ti=new Ticket();
		
		Thread t=new Thread(ti);
		Thread t1=new Thread(ti);
		Thread t2=new Thread(ti);
		Thread t3=new Thread(ti);
		
	
		
		t.start();
		t1.start();
		t2.start();
		t3.start();
		
	}

}
