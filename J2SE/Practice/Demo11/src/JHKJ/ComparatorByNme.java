package JHKJ;
/*2013年7月29日16:10:51
 * 以构造函数为主
 * new Comparator 来使用
 * */
import java.util.Comparator;

public class ComparatorByNme implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Person p=(Person)o1;
		Person p1=(Person)o2;
		
		int temp=p.getName().compareTo(p1.getName());
		
		

		
		return temp==0?p.getNum()-p1.getNum():temp;
	}

}
