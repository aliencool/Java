package Thread3;

/*2013��5��22��22:11:20
 * �̵߳�ͨ��(�ȴ�����-����):
 * 
 * */
//��Դ
class Resource
{
	String name;
	int x=0;
	String sex;
	boolean flag=false;
	public void input()
	{
		
		synchronized(this)
		{		
			if(this.flag)//���Ϊ�棬��ô�ͱ��������Ѿ�д��ȥ����Դ�������Ϊ�پ�˵��д����Դû��д��ȥ!
			{
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(x==0)//1
			{
				this.name="Mike";
				this.sex="Boy";
			}
			else//1
			{
				this.name="Penny";
				this.sex="Gril";
			}
			
			this.flag=true;//2
			this.notify();//3
		
		}
		
		x=(x+1)%2;
	}
	public void show()
	{
		synchronized(this){
			
			if(!this.flag)//4
			{
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("����:"+this.name+"..............."+"�Ա�"+this.sex);
			this.flag=false;
			this.notify();
		}
	}
}
//����
class Iuput implements Runnable
{
	Resource re=new Resource();
	
	Iuput(Resource re)
	{
		this.re=re;
	}
	
	@Override
	public void run() {
		while(true)
		{
			re.input();
		}
		
	}
}

//���
class Output implements Runnable
{
	Resource re=new Resource();
	Output(Resource re)
	{
		this.re=re;
	}
	
	@Override
	public void run() {
		
			while(true)
			{
			re.show();
			}
		
		
	}
	
}
public class thread8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//������Դ:
		Resource re=new Resource();
		
		//��������
		Iuput in=new Iuput(re);
		Output ou=new Output(re);
		
		//�����߳�:
		Thread th1=new Thread(in);
		Thread th2=new Thread(ou);
		
		//��������
		th1.start();
		th2.start();
	
	}

}
