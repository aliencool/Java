package JHKJ;
/*2013��7��13��16:21:24
 * ѧϰ�����������Ͱ�װ��
 * ����StringBulider
 * ���ǳ�ʼ������
 * ð��1~n-1 ����Ҫ��i
 * */
public class PackClassTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="20 78 9 -7 88 36 29";
		System.out.println("����֮ǰ:"+msg);
		String num=spitArray(msg);	
		System.out.println("����֮��:"+num);
	}

	public static String spitArray(String msg) {
		//��һ����ȡ:
		String num[]=StringToArray(msg);
		//�ڶ���ת��
		int num1[]=StringToArray1(num);
		//����������
		int num2[]=SortInt(num1);
		//���Ĳ��������תΪ�ַ���
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
