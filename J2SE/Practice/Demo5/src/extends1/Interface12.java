package extends1;
/*2013年4月23日11:34:29
 * 多实现
 * 两个重复，只会覆盖一个;
 * 定义一个也是可以的
 * */
interface w {
	public abstract int add(int a,int b);
	}

interface B {
	 public abstract int add(int a,int b);
	}
class W{
	public int add(int a,int b){return a+b;}
}
class aImpl implements B
{

	

	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}
	
	}
public class Interface12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		aImpl a=new aImpl();
		System.out.println(a.add(99, 89));
	}

}
