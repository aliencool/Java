package dt;
/*2013年4月24日16:22:52
 * 多态:
 * 转换
 * */


public class duotai2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a=new Dog();
		a.eat();
		
		Dog c=(Dog)a;
		c.lookhome();
		
		
	
		
	}

}
