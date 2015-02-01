package extends1;
class A{
	int a=55;
	static{System.out.print("1");}

	A(){System.out.print("2");}
	A(int x){System.out.print("0");}
	public  void method(){System.out.print("3");}
	
}

public abstract class  overload_override extends A {
	public abstract void method();
	
	
	public static void main(String[] args) {
		A a=new A();
		
		a.method();

	}

}
