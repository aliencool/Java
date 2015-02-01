package Thread3;

/*2013年5月22日22:11:20
 * 线程的通信(等待唤醒-机制):
 * 
 * */
//资源
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
			if(this.flag)//如果为真，那么就表明他们已经写进去了资源！如果，为假就说明写进资源没有写进去!
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
			System.out.println("姓名:"+this.name+"..............."+"性别"+this.sex);
			this.flag=false;
			this.notify();
		}
	}
}
//输入
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

//输出
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
		
		//创建资源:
		Resource re=new Resource();
		
		//创建卡车
		Iuput in=new Iuput(re);
		Output ou=new Output(re);
		
		//创建线程:
		Thread th1=new Thread(in);
		Thread th2=new Thread(ou);
		
		//启动任务
		th1.start();
		th2.start();
	
	}

}
