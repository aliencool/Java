package JHKJ;
/*2013年7月13日16:21:24
 * 学习基本数据类型包装类
 * 忘记StringBulider
 * 忘记初始化数组
 * 冒泡1~n-1 里面要减i
 * */
public class PackClassTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="20 78 9 -7 88 36 29";
		System.out.println("排序之前:"+msg);
		String num=spitArray(msg);	
		System.out.println("排序之后:"+num);
	}

	public static String spitArray(String msg) {
		//第一步截取:
		String num[]=StringToArray(msg);
		//第二步转换
		int num1[]=StringToArray1(num);
		//第三步排序
		int num2[]=SortInt(num1);
		//第四步排序完成转为字符串
		String num3=ArrayToString(num2);
		return num3;
		
	}

	private static String ArrayToString(int[] num2) {
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < num2.length; i++) {
			if(i!=num2.length)
			{
				sb.append(num2[i]+" ");
			}
			else
			{
				sb.append(num2[i]);
			}
		}
		return sb.toString();
	}

	private static int[] SortInt(int[] num1) {
		// TODO Auto-generated method stub
		int temp=0;
		int k=0;
	/*	for (int i = 1; i <=num1.length-1; i++) {
			for (int j = 0; j < num1.length-i; j++) {
				if(num1[j]>num1[j+1])
				{
					temp=num1[j];
					num1[j]=num1[j+1];
					num1[j+1]=temp;
				}
			}
		}
		*/
		for (int i = 0; i < num1.length-1; i++) {
			k=i;
			for (int j = i+1; j <num1.length; j++) {
				if(num1[k]>num1[j])
				{
					k=j;
				}
			}
			if(k!=i)
			{
				temp=num1[i];
				num1[i]=num1[k];
				num1[k]=temp;
			}
		}
		
		
		return num1;
	}

	private static int[] StringToArray1(String[] num2) {
		// TODO Auto-generated method stub
		int num[]=new int[num2.length];
		for (int i = 0; i < num2.length; i++) {
			num[i]=Integer.parseInt(num2[i]);
		}
		return num;
	}

	private static String[] StringToArray(String msg) {
		// TODO Auto-generated method stub
		String num[]=msg.split(" ");
		
		return num;
	}


	

}
