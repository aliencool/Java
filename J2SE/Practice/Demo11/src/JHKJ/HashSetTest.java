package JHKJ;
import java.util.HashSet;
import java.util.Iterator;
/*学习自定义对象
 * 两个提高：第一HASHCODE 第二个提高EQUALS
 * */
class Person1
{
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj) return true;
		if(!(obj instanceof Person1)) throw new ClassCastException("类型错误");
		Person1 p1=(Person1)obj;
		return this.name.equals(p1.name)&&this.age==p1.age;
	}


	public Person1( String name,int age) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode()+this.age;//乘以9为了提高效率
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


}
public class HashSetTest {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet hs=new HashSet();
		hs.add(new Person1("List1",24));
		hs.add(new Person1("List1",24));
		hs.add(new Person1("List2",24));
		
		Iterator it=hs.iterator();
		while(it.hasNext())
		{
			Person1 p=(Person1)it.next();
			System.out.println(p.getName()+"  "+p.getAge());
		}
		
		
	}

}
