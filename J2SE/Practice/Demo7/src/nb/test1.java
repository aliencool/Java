package nb;
/*2013年4月25日21:58:26
 * 内部类:
 * 顶层类只能是PUBLIC与默认级别
 * 顶层类的值不能被更改
 * */
class Outer
{
	static int a=8;
	int b=9;	
	public  class A{
		
		Outer ou=new Outer();
		int b=ou.b;
	 
	 
	}
	void show(){A w=new A();}
}

public class test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
