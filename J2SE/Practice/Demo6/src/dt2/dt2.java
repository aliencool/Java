package dt2;
/*
 * 2013年4月25日16:52:20
 * 学习多态
 * 成员变量:编译:查看引用类型是否有这个变量。没有，则报错 看左边
 * 		         运行:查看引用类型是否有这个变量。没有，则报错 看左边
 * 成员函数:编译:查看引用类型是否有这个变量。没有，则报错 看左边
 * 		         运行:查看对象是否有这个变量。没有，则引用分类 看右边
 * */

class Animal
{
	int a=10;
	void Eat(){
		System.out.println("Don't konw");
	}
	static void Speak()
	{
		System.out.println("Don't konw");
	}
}

class Cat extends Animal
{
	void Eat(){
		System.out.println("Fish");
	}
	static void Speak()
	{
		System.out.println("猫猫叫");
	}
}

class Dog extends Animal
{

	void Eat(){
		System.out.println("Bone");
	}
	static void Speak()
	{
		System.out.println("狗狗叫");
	}
}



public class dt2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a=new Dog();
		System.out.println(a.a);//调用父类
		a.Eat();//调用子类
		a.Speak();//调用父类
	}

}
