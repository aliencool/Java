package Until;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*2013年8月8日21:30:33
 * getDateTimeInstance获取时间两个
 * SimpleDateFormat自定义格式
 * format进行转换
 * */
public class DateTest {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Datechangegeshi();
		
	}
	/*字符串转为日期
	 * 系统版
	 * 第一步:DateFormat.getxxxx 方法
	 * 第二步:parse(返回Date)
	 * 
	 * 自定义版
	 * 第一步:new SimpleDateFormat("构造函数");
	 * 第二部:parse(返回Date)
	 * */
	public static void StrchangeDate() throws ParseException {
		String str_date="2013--8--8";
		DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.LONG);//系统板
		dateFormat=new SimpleDateFormat("yyyy--m--d");
		Date date=dateFormat.parse(str_date);
		System.out.println(date);
	}

	/*日期转为指定的格式
	 * 系统版
	 * 第一步:DateFormat.getxxxx 方法
	 * 第二步:format(返回STRING)
	 * 
	 * 自定义版
	 * 第一步:new SimpleDateFormat("构造函数");
	 * 第二部:format(返回STRING)
	 * */
	public static void Datechangegeshi() {
		Date date=new Date();
		
		DateFormat dateFormat=DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
		String str_date;
		dateFormat=new SimpleDateFormat("yyyy//MM//WW//dd");
		 str_date=dateFormat.format(date);
		System.out.println(str_date);
	}

	public static void sop() {
		Date date=new Date();
		System.out.println(date);//转换当前
		
		Date date1=new Date(); 
		
		System.out.println(date1);//转换毫秒
		System.out.println(date1.after(date));//是否在之后
		System.out.println(date1.getTime());
	}

}
