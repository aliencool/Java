package JHKJ;

import java.util.*;

/*2013年7月23日16:31:39
 * 学习List
 * List:可重复 有序列
 * Add(开始，元素)可以选择位置
 * Remove()返回删除元素
 * Set()返回替换的元素
 * get()获取元素
 * */
public class ListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List li=new ArrayList();
		
		li.add("abc");
		li.add("abc1");
		li.add("abc2");
		li.add("abc3");
		
		System.out.println(li);
		
		//添加指定位置:
;		li.add(2,"abc0.5");
		System.out.println(li);
		
		//删除元素
		System.out.println("删除的元素:"+li.remove(2));
		
		//查找元素
		System.out.println("查找的元素:"+li.get(2));
		
		//修改元素
		System.out.println("修改的元素:"+li.set(0,"abc0" ));
		
		//截取元素:
		System.out.println("截取的元素:"+li.subList(1, 2));
	}

}
