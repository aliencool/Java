package Thread2;
/*2013年5月22日11:15:06
 * 线程的通信:
 * 1:同步要放到正确的位置，千万别放在while(true)的前面
 * 2:我们希望赋值完后马上输出
 * */
//资源
class Resource
{
	String name;
	String sex;
}
//输入
class Iuput implements Runnable
{
	Resource re=new Resource();
	int x=0;
	Iuput(Resource re)//保证线程锁的唯一性与共享同一资源
	{
		this.re=re;
	}
	
	@Override
	public void run() {
		while(true)
		{
			synchronized(re)
			{
				if(x==0)
				{
					re.name="Mike";
					re.sex="Boy";
				}
				else
				{
					re.name="Penny";
					re.sex="Gril";
				}
			}
			x=(x+1)%2;
		}
		
	}
}

//输出
class Output implements Runnable
{
	Resource re=new Resource();
	int x=0;
	Output(Resource re)//保证线程锁的唯一性与共享同一资源
	{
		this.re=re;
	}
	
	@Override
	public void run() {
		//synchronized(re)会永远拿着一个锁输出
		//{
			while(true)
			{
				synchronized(re){
					System.out.println("姓名:"+re.name+"..............."+"性别"+re.sex);
				}
			}
		//}
		
	}
	
}
public class thread7 {

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
