package nb2;
/*2013��4��27��17:12:05
 * �����ڲ���
 * ���ݺ��������ǽӿ����ͣ�����������(���¶����̫����)
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
/*̫�鷳
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