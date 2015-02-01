package Thread6;

import java.util.Random;

import Thread6.ThreadShare.A;
import Thread6.ThreadShare.B;

/*2013年6月6日16:42:41
 * 学习Threadlocal:主要解决不同线程使用同一数据产生不同结果
 * 单例模式结合为容器
 * */
public class ThreadLocalTest {
	
	
	
	
	
	public static void main(String[] args) {
		for(int i=0;i<2;i++)
		{   
		
			new Thread(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int data=new Random().nextInt();
					MyData.getThreadInstance().setName("name:"+data);
					MyData.getThreadInstance().setAge(data);
					new C().Cshow();
					new D().Dshow();
					
				}
				
			}).start();
			
		}

	}

}

class C
{
	public void Cshow()
	{
		System.out.println(Thread.currentThread().getName()+"........."+"C"+"..........."+MyData.getThreadInstance().getName()+MyData.getThreadInstance().getAge());
	}
}

class D
{
	public void Dshow()
	{
		System.out.println(Thread.currentThread().getName()+"........."+"D"+"..........."+MyData.getThreadInstance().getName()+MyData.getThreadInstance().getAge());
	}
}

class MyData//把相关联的资源集合在一起
{
	
	private String name;
	private int age;
	private static MyData mydata;
	private static ThreadLocal<MyData> tl=new ThreadLocal<MyData>();
	
	private MyData(){}
	public static MyData getThreadInstance()
	{
		mydata=tl.get();
		if(mydata==null)
		{
			mydata=new MyData();
			tl.set(mydata);
		}
		return mydata;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}