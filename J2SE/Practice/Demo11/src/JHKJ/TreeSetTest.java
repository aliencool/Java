package JHKJ;

import java.util.Iterator;
import java.util.TreeSet;

/*2013��7��28��17:46:35
 * ѧϰTreeSet��Ԫ���ܹ���������
 * 1:Ҫô�߱���CompareTO 
 * 2:Ҫô�Զ���
 * ����û��ʵ�� ����TEMP
 * */
public class TreeSetTest {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet ts=new TreeSet(new ComparatorByNme());
		ts.add(new Person("wangwu",21));
		ts.add(new Person("wangwu1",23));
		ts.add(new Person("wangwu2",22));
		ts.add(new Person("aangwu3",24));
		
		Iterator it=ts.iterator();
		while(it.hasNext())
		{
			//System.out.println(((Person) it.next()).getName()+((Person) it.next()).getNum());�������´���
			Person p=(Person)it.next();
			System.out.println(p.getName()+"  "+p.getNum());
		}
	}

}
