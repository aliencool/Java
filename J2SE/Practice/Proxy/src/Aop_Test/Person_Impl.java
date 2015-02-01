package Aop_Test;

public class Person_Impl implements Person_Interface{

	@Override
	public void printf(String s) {
		// TODO Auto-generated method stub
		System.out.println("我在使用proxy实例");
	}

}
