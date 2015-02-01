package JHKJ;
/*2013年7月28日16:45:26
 * ArrayList 只有contanis 才可以有包含
 * 第一：忘记写contanis
 * */
import java.util.ArrayList;
import java.util.Iterator;

class Person implements Comparable
{
	private String name;
	
	public Person(String name, int num) {
		this.name = name;
		this.num = num;
	}
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj) return true;
		if(!(obj instanceof Person)) throw new ClassCastException("类型错误");
		Person p1=(Person)obj;
		return this.name.equals(p1.name)&&this.num==p1.num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	private int  num;
	
	public int compareTo(Object o)
	{
		Person p=(Person)o;
		int temp=this.num-p.num;
		return temp==0?this.name.compareTo(p.name):temp;
		
	}
}


public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList ay=new ArrayList();
		ay.add(new Person("Linked2", 21));
		ay.add(new Person("Linked2", 31));
		ay.add(new Person("Linked4", 41));
		ay.add(new Person("Linked5", 51));
		ay.add(new Person("Linked2", 31));
		ay.add(new Person("Linked4", 41));
		ay.add(new Person("Linked5", 51));
		
		
		
		ay=GetElementssingle(ay);
		Iterator it=ay.iterator();
		while(it.hasNext())
		{
			//System.out.println(((Person) it.next()).getName()+((Person) it.next()).getNum());不断向下错误
			Person p=(Person)it.next();
			System.out.println(p.getName()+"  "+p.getNum());
		}
	}

	public static ArrayList GetElementssingle(ArrayList ay) {
		// TODO Auto-generated method stub
		ArrayList a=new ArrayList();
		Iterator it=ay.iterator();
		while(it.hasNext())
		{
			Object p=it.next();
			if(!(a.contains(p)))
			{
				a.add(p);
			}
			
		}
		return a;
	}

}
