/*
 * 2013年4月19日22:01:29
 * 学习单例模式
 * 三步:
 * 私有构造
 * 私有静态实例
 * 公有返回
 * */
package clas3;

//第一种方式(经常用于开发)
class Test{
	int num;
	private static Test ts=new Test();
	
	private Test(){}
	public static Test getInstance()
	{
		return ts;
	}
	
	public void setNum(int num)
	{
		this.num=num;
	}
	
	public int getNum()
	{
		return num;
	}
	
}

//第二种方式 多线程不能保持模式
class Test1{
	private static Test1 ts1=null;
	
	private Test1(){}
	
	public static Test1 getInstance()
	{
		if(ts1==null)ts1=new Test1();
		return ts1;
	}
	
}
//第二种方式 多线程不能保持模式(解决方法,再多一次判断和锁)
class Test2{
	private static Test2 ts1=null;
	
	private Test2(){}
	
	public static Test2 getInstance()//特别注意static 没有this 关键字
	{	
		if(ts1==null)//如果，不加判断每个线程都要去获得资格后再次判断
		{
			synchronized(Test2.class)//拿着锁只能使用一个线程进行返回
			{
				if(ts1==null)ts1=new Test2();
			}
		}
		return ts1;
	}
	
}


public class single {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test tt=Test.getInstance();
		Test tt1=Test.getInstance();
		
		tt.setNum(50);
		tt1.setNum(98);
		
		System.out.println(tt.getNum());
		System.out.println(tt1.getNum());
	}

}
