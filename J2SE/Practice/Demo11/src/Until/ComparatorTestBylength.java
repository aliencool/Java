package Until;

import java.util.Comparator;

public class ComparatorTestBylength implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		int temp=o2.length()-o1.length();
		return temp==0?o1.compareTo(o2):temp;
	}

}
