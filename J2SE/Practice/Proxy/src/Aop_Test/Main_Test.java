package Aop_Test;

public class Main_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aop_Proxy ss=new Aop_Proxy(new Person_Impl());
		Person_Interface impl=(Person_Interface)ss.getInstance();
		System.out.println(impl.getClass());
		impl.printf("w");
	}

}
