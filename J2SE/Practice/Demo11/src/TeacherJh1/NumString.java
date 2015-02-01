package TeacherJh1;
/*2013年7月3日17:07:37
 * 错误:判断
 * indexof:还有一个从什么时候开始
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
			//str=str.substring(k+msg.length());第一种
			k=k+msg.length();//第二种
		}
		System.out.println(j);
		
		
	}

}
