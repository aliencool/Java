package Io6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*2013年8月23日21:47:48
 * 对象的持久化只是为了把对象放进硬盘现在直接使用  必须实现serializble;
 * 写进去的有:对象类，类签名，各种值
 * 
 * Serializable:为了验证是否兼容类。
 * 比如，服务器崩溃，再读要配ID!
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
		
		//对象序列
		ObjectOutputStream oos=new  ObjectOutputStream(new FileOutputStream("1.objec"));
		oos.writeObject(new Person(30, "lisi"));
		oos.close();
		
		//对象反序列 必须有序列化类文件  (才加转换失败的)
		ObjectInputStream ios=new  ObjectInputStream(new FileInputStream("1.objec"));
		Person p=(Person)ios.readObject();
		System.out.println(p.getName());
		
	}

}
