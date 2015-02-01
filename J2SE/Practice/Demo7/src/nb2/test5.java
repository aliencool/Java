package nb2;
/*2013年4月27日17:12:05
 * 匿名内部类
 * 传递函数参数是接口类型，不超过三个(重新定义个太复杂)
 * */
interface test{
	class b{
		void show2(){System.out.println("Hello");}
	}
	void show();
	void show1();
}
public class test5 {

	/**
	 * @param args
	 */
	public test5(){}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          test1(new test(){
        	  b s=new b();

        	  public void show(){System.out.println("Hello");}
              public  void show1(){System.out.println("World");}
          }); 
	}
	public static void test1(test tt)
	{
		tt.show();
		tt.show1();
	}

}
/*太麻烦
class ttt implements test
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
*/