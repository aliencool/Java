package dt;
/*2013��4��24��15:54:42
 * ��̬:
 * ����˴�����չ�ԣ�δ����֪!
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
		Eat(new Cat());//����
		Eat(new Dog());//����
		Eat(new Pig());//����
	}
	//ǰ��
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
