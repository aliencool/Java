package fanxing;
/*2013��8��4��21:37:49
 * ������ĺô���1������ǿת  2��תΪ�����쳣
 * ���ͷ�����1������������ȷ�� 2:��̬����ֻ�ܶ��巺�ͷ��� �ڷ���ֵǰ���<> 3:�������ͷ��ͻ���ݶ���
 * ���ͽӿڣ�1�����ǰ�滹����ȷʹ����� 2:������ȷ
 * */

interface Inter<T>
{
	public void show(T t);
	
	}
class Test<w> implements Inter<w>
{

	@Override
	public void show(w t) {
		// TODO Auto-generated method stub
		System.out.println("w:"+t);
	}
}


class Test1 implements Inter<String>
{

	@Override
	public void show(String t) {
		// TODO Auto-generated method stub
		System.out.println("w:"+t);
	}
	}




class Tool<o,i>
{
	private o O;
	private i I;
	public i getI() {
		return I;
	}

	public void setI(i i) {
		I = i;
	}

	public o getObject() {
		return O;
	}

	public void setgetObject(o o) {
		O = o;
	}
	
	public static <w> void show(w O)
	{
		System.out.println("w:"+O);
	}
}
class Student extends Person
{
	public Student(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

}


class Work extends Person
{
	public Work(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}
	
}

public class fanxingClassTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tool<Student,Work> tool=new Tool<Student, Work>();
		Student st=tool.getObject();
		Work wo=tool.getI();
		tool.show(3);
		
		
		
		Test<Integer> t=new Test<Integer>();
		t.show(5);
	
	}

}
