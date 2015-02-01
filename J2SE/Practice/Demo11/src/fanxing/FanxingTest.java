package fanxing;

import java.util.Iterator;
import java.util.TreeSet;
/*2013年8月4日17:56:12
 * comparatable是接口
 * conparator是新类比较
 * */



class Person implements Comparable<Person>
{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		int temp=this.age-o.age;
		return temp==0?this.getName().compareTo(o.getName()):temp;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(!(obj instanceof Person)) throw new ClassCastException();
		Person p=(Person)obj;
		return this.getAge()==p.getAge()&&this.getName().equals(p.getName());
	}
	
	


}
public class FanxingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Person> tr=new TreeSet<Person>(new ComparatableByName());
		tr.add(new Person("Linked2", 21));
		tr.add(new Person("Linked1", 31));
		tr.add(new Person("Linked4", 41));
		
		Iterator<Person> it=tr.iterator();
		while(it.hasNext())
		{
			Person p1=it.next();
			System.out.println(p1.getAge()+" "+p1.getName());
		}
		
	}

}
