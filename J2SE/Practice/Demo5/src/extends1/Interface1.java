package extends1;
/*2013年4月23日11:25:18
 * 定义
 * */
interface Demo {
 public static final int x=88;
 public abstract void show();
 public abstract void show1();
}

class DemoImpl implements Demo
{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show1() {
		// TODO Auto-generated method stub
		
	}


   	
}

public class Interface1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Demo.x);
		System.out.println(DemoImpl.x);
	}

}
