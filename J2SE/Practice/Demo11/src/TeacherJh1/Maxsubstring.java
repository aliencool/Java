package TeacherJh1;

public class Maxsubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="fdsfsdfabcd";
		String dwe="fdsfvxcvfdgabcd";
		
		for (int i = 0; i < dwe.length(); i++) {
			for(int x=0,k=dwe.length()-i;k!=dwe.length()+1;x++,k++)
			{
				String sub=dwe.substring(x, k);
				if(msg.contains(sub))
				{System.out.println(sub);}
			}
		}
		
	}

}
