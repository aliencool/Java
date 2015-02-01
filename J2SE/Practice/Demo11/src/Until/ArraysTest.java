package Until;
/*2013年8月7日16:20:01
 * 学习数组转集合(ASLIST) 集合转数组(toArray)
 * 1:数组转集合：为了增加对数组的操作，不能对其长度进行操作   .......  基本数据类型存储的是数组名  对象的话把元素直接存储进去 
 * 2:集合转数组：为了限定对集合的操作，不能对其长度进行操作（可以重载泛型toArray(new xxxxx)）  .......   小于长度 自动创建 大于长度会自动填充为NULL
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
