package JHKJ;
/*2013��7��29��16:10:51
 * �Թ��캯��Ϊ��
 * new Comparator ��ʹ��
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
