package Until;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*2013��8��8��21:30:33
 * getDateTimeInstance��ȡʱ������
 * SimpleDateFormat�Զ����ʽ
 * format����ת��
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
	/*�ַ���תΪ����
	 * ϵͳ��
	 * ��һ��:DateFormat.getxxxx ����
	 * �ڶ���:parse(����Date)
	 * 
	 * �Զ����
	 * ��һ��:new SimpleDateFormat("���캯��");
	 * �ڶ���:parse(����Date)
	 * */
	public static void StrchangeDate() throws ParseException {
		String str_date="2013--8--8";
		DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.LONG);//ϵͳ��
		dateFormat=new SimpleDateFormat("yyyy--m--d");
		Date date=dateFormat.parse(str_date);
		System.out.println(date);
	}

	/*����תΪָ���ĸ�ʽ
	 * ϵͳ��
	 * ��һ��:DateFormat.getxxxx ����
	 * �ڶ���:format(����STRING)
	 * 
	 * �Զ����
	 * ��һ��:new SimpleDateFormat("���캯��");
	 * �ڶ���:format(����STRING)
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
		System.out.println(date);//ת����ǰ
		
		Date date1=new Date(); 
		
		System.out.println(date1);//ת������
		System.out.println(date1.after(date));//�Ƿ���֮��
		System.out.println(date1.getTime());
	}

}
