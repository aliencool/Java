package dt2;
/*
 * 2013��4��25��16:52:20
 * ѧϰ��̬
 * ��Ա����:����:�鿴���������Ƿ������������û�У��򱨴� �����
 * 		         ����:�鿴���������Ƿ������������û�У��򱨴� �����
 * ��Ա����:����:�鿴���������Ƿ������������û�У��򱨴� �����
 * 		         ����:�鿴�����Ƿ������������û�У������÷��� ���ұ�
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
		System.out.println("èè��");
	}
}

class Dog extends Animal
{

	void Eat(){
		System.out.println("Bone");
	}
	static void Speak()
	{
		System.out.println("������");
	}
}



public class dt2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a=new Dog();
		System.out.println(a.a);//���ø���
		a.Eat();//��������
		a.Speak();//���ø���
	}

}
