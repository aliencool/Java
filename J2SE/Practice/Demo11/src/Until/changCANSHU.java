package Until;
/*2013��8��8��6:04:33
 * �ɱ����:��һ���Զ�תΪ���� �ڶ���ֻ����ǰ����ܲ���
 * ��̬���룺���ܳ����ظ����ֵ�
 * */
import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.List;
public class changCANSHU {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=sort(1,2,3);
		System.out.println(sum);
	}

	private static int sort(int i, int... j) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int k = 0; k < i; k++) {
			System.out.println(j[0]);
			sum=j[i]+j[i];
		}
		return sum;
	}

}
