package Until;

import java.util.*;

import JHKJ.ComparatorByNme;

public class CollectionsTest {

	/**
	 * @param <T>
	 * @param args
	 */
	public static  void main(String[] args) {
		Collections.reverseOrder(new ComparatorTestBylength());
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		Collections.max(list);
		list.add("ba");
		list.add("faa");
		
		list.add("vaaaa");
		list.add("aaaa");
		Collections.synchronizedList(list);
		System.out.println(list);
	}

	private static void myCollectionsSet(List<?> list,int i,int j) {
		// TODO Auto-generated method stub
		List l=list;
		l.set(i, l.set(j, l.get(i)));
		
	}

	public static <T extends Comparable<? super T> > void myCollectionsSory(List<T> list,Comparator<? super T> c) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j <list.size()-1; j++) {
				if(c.compare(list.get(i), list.get(j))>0)
				{
					myCollectionsSet(list, i, j);
				}
			}
		}
		
	}
	
}
