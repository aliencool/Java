package clas2;
/* 2013��4��19��15:30:00
 * �������Ļ�������
 * ����ʹ�þ�̬û����������
 * */
public class ArrayToolDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr={1,4,6,78,22,64,1};
		int max;
		int index;
	
		
		max=ArrayTool.getmax(arr);
		System.out.println("Max:"+max);
		
		ArrayTool.sort(arr);
		System.out.print("Sort:");
		for(int x=0;x<arr.length;x++)
		{
			  System.out.print(arr[x]+" ");
		}
		System.out.println();
		
		index=ArrayTool.getindex(arr, 64);
		System.out.println("Index:"+index);
		

	}

}
