package clas2;
	/**
	 *@author 联系
	 *@version V1.0
	 */
public class ArrayTool {
	private ArrayTool(){}
	/**
	 *@param arr 接受一个元素为INT的数组
	 *@return 该数组最大的元素
	 */
   public static int getmax(int []arr)
   {
	 
	   int max=0;
	   
	   for(int x=0;x<arr.length-1;x++)
	   {
		   if(max<arr[x]){max=arr[x];}
	   }
	   
	   return max;
	   
   }
	/**
	 * 数组排序
	 *@param arr 接受一个元素为INT的数组
	 */
   public static void sort(int []arr)
   {
	   int i;
	   int j;
	   int temp=0;
	   
	   for(i=1;i<=arr.length-1;i++)
	   {
		   for(j=0;j<arr.length-i;j++)
		   {
			   if(arr[j]>arr[j+1])
			   {
				   temp=arr[j];
				   arr[j]=arr[j+1];
				   arr[j+1]=temp;   
			   }	   
		   }
		   
	   }
   }
	/**
	 *@param arr 接受一个元素为INT的数组
	 *@return 查找数组的元素的角标
	 */
   public static int getindex(int []arr,int x)
   {
	   int low=0;
	   int mid=0;
	   int hight=arr.length-1;
	   
	   while(low<=hight)
	   {
		   mid=(low+hight)/2;  
		   if(arr[mid]>x){low=mid+1;}
		   else
           if(arr[mid]<x){hight=mid-1;}
           else return mid;
		   
	   }
	   return -1;
   }
   
}
