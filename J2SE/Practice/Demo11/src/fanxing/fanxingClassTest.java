package fanxing;
/*2013年8月4日21:37:49
 * 泛型类的好处：1：不用强转  2：转为编译异常
 * 泛型方法：1：参数方法不确定 2:静态方法只能定义泛型方法 在返回值前面加<> 3:类类类型泛型会根据对象
 * 泛型接口：1：如果前面还不明确使用类的 2:必须明确
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
