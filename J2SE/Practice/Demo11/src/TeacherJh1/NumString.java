package TeacherJh1;
/*2013��7��3��17:07:37
 * ����:�ж�
 * indexof:����һ����ʲôʱ��ʼ
 * */
public class NumString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="nbaernbatynbauinbaopnbanba";
		String msg="nba";
		int k=0;
		int j=0;
		
		while((k=str.indexOf(msg,k))!=-1)
		{
			j++;	
			//str=str.substring(k+msg.length());��һ��
			k=k+msg.length();//�ڶ���
		}
		System.out.println(j);
		
		
	}

}
