package fanxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import fanxing.Person;

/*
 * 2013年8月4日21:51:34
 * 学习泛型的限定
 * 1:只能进入一个体系
 * 2:"?”表示通配符的意思
 * 3:转型以后会按照原来的语言规则
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
			//System.out.println(((Person) it.next()).getName()+((Person) it.next()).getNum());不断向下错误
			Person p=it.next();
			System.out.println(p.getName()+"  "+p.getAge());
		}
	}

}
