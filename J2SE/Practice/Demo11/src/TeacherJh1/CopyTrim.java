package TeacherJh1;

public class CopyTrim {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str=" sd fsdf f ";
		int k=0;
		int count=0;
		String str1=mytrim(str);
		System.out.println(str1);

	}

	private static String mytrim(String str) {
		// TODO Auto-generated method stub
		int statr=0;
		int end=str.length()-1;
		while(statr<=end&&str.charAt(statr)==' ')
		{
			statr++;
		}
		while(statr<=end&&str.charAt(end)==' ')
		{
			end--;
		}
		return str.substring(statr, end+1);
	}

}
