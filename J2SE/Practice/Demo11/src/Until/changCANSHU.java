package Until;
/*2013年8月8日6:04:33
 * 可变参数:第一：自动转为数组 第二：只能在前面接受参数
 * 静态导入：不能出现重复名字的
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
