package clas1;
/*
 * 2012年4月2日17:37:45
 * This表示当前对象，每个，对象都有This
 * 细节一:必须第一个初始化
 * 细节二:小心死循环
 * */
public class This {
	private int age;
	  
	
	  This(){}
	This(int i){this();System.out.println("!!");}
	boolean compare(This p)
	{
	
		
		return this.age==p.age;
	}
	public static void main(String []args)
	{
		
	}
	
}


