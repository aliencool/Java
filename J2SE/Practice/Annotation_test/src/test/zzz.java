package test;

/**
 * @�๦��˵����շת
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-16 ����03:36:16
 * @�汾��V1.0
 */
public class zzz {

	public static void main(String[] args)
	{
		System.out.println(division(1515,60));
		
		
		int a[]={1,2,3,4,5,6,7,8};
		System.out.println(sort1(a,0,7,6));
	}
	
	public static int division(int m,int n)
	{
		int k;
		return (k=(m%n))==0?n:division(n,k);
	}
	
	public static int sort1(int a[],int s,int e,int key)
	{
		int mid=(s+e)/2;
		if(s<=e)return a[mid]==key?mid:a[mid]>key?sort1(a,s,mid-1,key):sort1(a,mid+1,e,key);
		else return 0;
	}
}
