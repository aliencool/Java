package Ex2;
/*2013年5月7日22:25:04
 * 面向对象的异常转换应用
 * 1：异常转换
 * 2：自定义异常
 * */
/*
 * 异常
 */
class LanPingException extends Exception
{
	LanPingException(String msg)
	{
		super(msg);
	}
}

class MaoyanException extends Exception
{
	MaoyanException(String msg)
	{
		super(msg);
	}
}
class NoplaneException extends Exception
{
	NoplaneException(String msg)
	{
		super(msg);
	}
}
/*
 * 电脑运行
 */
class Computer
{
	private   int state=2; 
	public void run()throws LanPingException,MaoyanException//电脑发生异常只有电脑知道
	{
		if(state==1) throw new LanPingException("电脑蓝屏");
		if(state==2) throw new MaoyanException("电脑冒烟");
		
		System.out.println("电脑运行");
	}
	
	public void rest()
	{
		state=0;
	}
}
class weixiu
{
	public static boolean rest(Computer comp)
	{
		comp.rest();
		return false;
	}

}

/*
 * 老师对象
 */
class Teacher
{
	private String name;
	private	Computer comp;
	Teacher(String name)
	{
		this.name=name;
		comp=new Computer();
		
	}

	public void prelect()throws NoplaneException //throws MaoyanException 冒烟不属于公司范围，应该抛出一个公司能处理问题
	{
		try{
		comp.run();
		System.out.println(name+"讲课");
		}
		catch(LanPingException e)//异常可以处理(预处理)
		{
			System.out.println(e.toString());
			comp.rest();//不处理永远都是死循环
			prelect();
		}
		catch(MaoyanException e)//异常不可以处理,则抛出(预处理)
		{
			
			System.out.println(e.toString());
			test();
			//可以对电脑进行维修
			if(weixiu.rest(comp))
			{
				System.out.println("维修好了");
				prelect();
			}
			else
			{
				throw new NoplaneException("无法处理");
			}
		}
		
		
	}
	public void test()
	{
		System.out.println("练习");
	}
	public  void rest()
	{
		comp.rest();
		
	}
}

public class Exceptionapply {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Teacher t=new Teacher("毕老师");
			
		try{
		t.prelect();
		}
		catch(NoplaneException e)
		{
			
			System.out.println("换人");
			t=new Teacher("黄老师");
			try {
				t.rest();
				t.prelect();
			} catch (NoplaneException e1) {
				e1.printStackTrace();
			}
		}
	}

}
