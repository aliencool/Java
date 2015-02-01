package nb;
/* 2013年4月26日16:30:46
 * 继承与同名:
 * 1:子类必须使用对象.super()
 * 3:同名不会覆盖，因为，在不同class文件中
 * */
class Oute
{
	int a;
	
	
	public   class Inner{
		Inner(){
		}
		void method(){System.out.println(a);}
		
	}
	
}

class Sample extends Oute.Inner
{
	Sample(Oute o){o.super();}
	public  class Inner{
		Inner(){}
		void method(){System.out.println(55);}
		
	}
}

public class test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Oute o=new Oute();
		Sample s=new Sample(o);
	
		

	}

}
