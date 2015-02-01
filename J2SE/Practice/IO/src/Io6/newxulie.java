package Io6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*2013��8��23��21:47:48
 * ����ĳ־û�ֻ��Ϊ�˰Ѷ���Ž�Ӳ������ֱ��ʹ��  ����ʵ��serializble;
 * д��ȥ����:�����࣬��ǩ��������ֵ
 * 
 * Serializable:Ϊ����֤�Ƿ�����ࡣ
 * ���磬�������������ٶ�Ҫ��ID!
 * */
class Person implements Serializable
{
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private transient String name;
}

public class newxulie {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		//��������
		ObjectOutputStream oos=new  ObjectOutputStream(new FileOutputStream("1.objec"));
		oos.writeObject(new Person(30, "lisi"));
		oos.close();
		
		//�������� ���������л����ļ�  (�ż�ת��ʧ�ܵ�)
		ObjectInputStream ios=new  ObjectInputStream(new FileInputStream("1.objec"));
		Person p=(Person)ios.readObject();
		System.out.println(p.getName());
		
	}

}
