package Until;
/*2013年8月9日17:31:49
 * 日期之间除法
 * */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetwoTest {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		MyMethod();
		
	}

	public static void MyMethod() throws ParseException {
		String str_date1="2012-3-17";
		String str_date2="2012-3-18";
		DateFormat dateformat=DateFormat.getDateInstance();
		
		Date date1=dateformat.parse(str_date1);
		System.out.println("日期1："+date1);
		Date date2=dateformat.parse(str_date2);
		System.out.println("日期2："+date2);
		
		long str=date1.getTime();
		long str1=date2.getTime();	
		long sub=str1-str;
		
		int sub2=(int)(sub/1000/60/60/24);
		System.out.println(sub2);
		
	}

}
