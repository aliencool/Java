package Until;
/*2013��8��7��16:20:01
 * ѧϰ����ת����(ASLIST) ����ת����(toArray)
 * 1:����ת���ϣ�Ϊ�����Ӷ�����Ĳ��������ܶ��䳤�Ƚ��в���   .......  �����������ʹ洢����������  ����Ļ���Ԫ��ֱ�Ӵ洢��ȥ 
 * 2:����ת���飺Ϊ���޶��Լ��ϵĲ��������ܶ��䳤�Ƚ��в������������ط���toArray(new xxxxx)��  .......   С�ڳ��� �Զ����� ���ڳ��Ȼ��Զ����ΪNULL
 * */

import java.util.*;

public class ArraysTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TO
			List<String> list=new ArrayList<String>();
			list.add("a");
			list.add("b");
		
			String[] str=list.toArray(new String[list.size()]);
			System.out.println(Arrays.toString(str));
			System.out.println(str[0]);
			
			String[] str1={"a","b","c"};
			String [] str2=Arrays.copyOf(str1, 3);
			System.out.println(Arrays.toString(str2));
		
			
			
			
			String []msg={"I","Love","China"};
			List<String> list5=Arrays.asList(msg);
			System.out.println(list5);
			
			String[] msg1=list5.toArray(new String[list.size()]);
	}

}
