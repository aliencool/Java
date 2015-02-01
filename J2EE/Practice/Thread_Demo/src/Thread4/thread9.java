package Thread4;
/*2013��6��3��10:17:07
 * �ȴ�-���� �������߶�������
 * while �ǻ��Ѻ�����ж��ܲ���ִ��
 * notifyAll �Ǳ�֤�������������(���ѶԷ�)
 * */

class Resource
{
	String name;
	int count=0;
	boolean flag=false;
	public synchronized void setName(String s)
	{
		while(flag)//��������   ����취��ȫ������!! ���� to --���� t1 ˯��
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
			name=s+count;
			count++;
			System.out.println(Thread.currentThread().getName()+"...����..."+name);
			flag=true;
			notifyAll();
		
	}
	
	public synchronized void Out()
	{
		while(!flag)//�������� ����취��ȫ������ ����취��ȫ������!! ���� t2 --���� t3 ˯��
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
			System.out.println(Thread.currentThread().getName()+"...����..."+name);
			flag=false;
			notifyAll();
		
	}
}

class Scz implements Runnable
{
	private Resource r;
	Scz(Resource r)
	{
		this.r=r;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
			while(true)
			{
				r.setName("��Ѽ");
			}
	}	

}

class Xfz implements Runnable
{
	private Resource r;
	Xfz(Resource r)
	{
		this.r=r;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
			while(true)
			{
				r.Out();
			}
	}	

}

public class thread9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Resource r=new Resource();
			Scz scz=new Scz(r);
			Xfz xfz=new Xfz(r);
			
			Thread t0=new Thread(scz);
			Thread t1=new Thread(scz);
			Thread t2=new Thread(xfz);
			Thread t3=new Thread(xfz);
			
			t0.start();
			t1.start();
			t2.start();
			t3.start();

	}

}
