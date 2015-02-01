package nb;
/*2013年4月26日17:12:02
 * 匿名类:
 * 1:使用成员方法必须在本类中有
 * 2:{}只能使用一次构造代码块
 * 3:成员变量与new Thread(new XX{})均可以定义
 * 4:局部变量传递给构造函数必须是final
 * */

public class test4 {
        int a;
	/**
	 * @param args
	 */
        test4(){}
        test4(int a){}
        void method(){System.out.println(1);}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=5;
		test4 t4=new test4(a){{}/*构造代码块*/void method(){System.out.println(a);}
		};
		t4.method();
		
		
		
	}

}
