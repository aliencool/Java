package fanxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import fanxing.Person;

/*
 * 2013��8��4��21:51:34
 * ѧϰ���͵��޶�
 * 1:ֻ�ܽ���һ����ϵ
 * 2:"?����ʾͨ�������˼
 * 3:ת���Ժ�ᰴ��ԭ�������Թ���
 * */
public class fanxingxiandingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Work> ay=new ArrayList<Work>();
		ay.add(new Work("Linked1", 21));
		ay.add(new Work("Linked2", 32));
		ay.add(new Work("Linked3", 43));
		
		
		ArrayList<Student> ay1=new ArrayList<Student>();
		ay1.add(new Student("Linked4", 24));
		ay1.add(new Student("Linked5", 35));
		ay1.add(new Student("Linked6", 46));
		
		PrintCollections(ay);
		PrintCollections(ay1);
	}

	public static void PrintCollections(Collection<? extends Person> ay) {
		Iterator<? extends Person> it=ay.iterator();
		while(it.hasNext())
		{
			//System.out.println(((Person) it.next()).getName()+((Person) it.next()).getNum());�������´���
			Person p=it.next();
			System.out.println(p.getName()+"  "+p.getAge());
		}
	}

}
