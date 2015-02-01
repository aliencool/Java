package JHKJ;

import java.util.Iterator;
import java.util.TreeSet;

/*2013年7月28日17:46:35
 * 学习TreeSet：元素能够有序排序
 * 1:要么具备有CompareTO 
 * 2:要么自定义
 * 错误：没有实现 返回TEMP
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
			//System.out.println(((Person) it.next()).getName()+((Person) it.next()).getNum());不断向下错误
			Person p=(Person)it.next();
			System.out.println(p.getName()+"  "+p.getNum());
		}
	}

}
