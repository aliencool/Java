package nb;
/*2013��4��25��21:58:26
 * �ڲ���:
 * ������ֻ����PUBLIC��Ĭ�ϼ���
 * �������ֵ���ܱ�����
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
