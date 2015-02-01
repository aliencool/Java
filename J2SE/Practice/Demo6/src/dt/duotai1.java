package dt;
/*2013年4月24日15:54:42
 * 多态:
 * 提高了代码扩展性，未卜先知!
 * */
abstract class Animal
{
	abstract void eat();
}

class Dog extends Animal{
	void eat(){
		System.out.println("Eating its bone");
	}
	void lookhome()
	{
		System.out.println("look..home");
	}
	
}

class Cat extends Animal{
	void eat(){
		System.out.println("Eating its fish");
	}
	
}

class Pig extends Animal{
	void eat(){
		System.out.println("Eating  anyone");
	}
	
}

public class duotai1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Eat(new Cat());//后期
		Eat(new Dog());//后期
		Eat(new Pig());//后期
	}
	//前期
	public static void Eat(Animal a)
	{
		
		a.eat();
	   
		if(a instanceof Dog)
		{
			Dog c=(Dog)a;
			c.eat();
			c.lookhome();
		}
	}

}
