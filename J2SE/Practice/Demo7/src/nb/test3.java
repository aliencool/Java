package nb;
/* 2013��4��26��16:30:46
 * �̳���ͬ��:
 * 1:�������ʹ�ö���.super()
 * 3:ͬ�����Ḳ�ǣ���Ϊ���ڲ�ͬclass�ļ���
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
