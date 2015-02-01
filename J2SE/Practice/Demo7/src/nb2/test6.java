package nb2;
/*2013年4月27日17:28:12
 * 匿名细节:
 * 匿名子类对象定义没有父类的方法不能使用。
 * 因为，向上转型了，不能使用子类的特有方法.
 * 
 * 为什么编译不报错？
 * 因为，我定义子类对象的特有，不关父类有事情!!!!
 * */
public class test6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object o=new Object(){
			void show(){
				System.out.println("哈哈");
			}
		};
		
	}

}
