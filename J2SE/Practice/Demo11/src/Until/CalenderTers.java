package Until;
/*2013��8��9��17:40:25
 * month+1
 * week-1
 * */
import java.util.Calendar;
import java.util.*;

/*2013��8��9��17:32:08
 * 
 * */
public class CalenderTers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar  calendar=Calendar.getInstance();
		
		calendar.set(2088, 8,8);//���õ�ǰʱ��
		calendar.add(Calendar.YEAR, -2);//Add��ʾʱ���ƫ��
		
		
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONDAY)+1;
		int day=calendar.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year+"��"+month+"��"+day+"��"+calendar.get(Calendar.DAY_OF_WEEK));
	}

	public static void Test() {
		Calendar  calendar=Calendar.getInstance();
		
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONDAY)+1;
		int day=calendar.get(Calendar.DAY_OF_MONTH);
		int week=calendar.get(Calendar.DAY_OF_WEEK)-1;
		
		Map<Integer,String> map=new HashMap<Integer,String>();
		map.put(1, "Sunday");
		map.put(2, "Tuerday");
		map.put(3, "Wendesday");
		map.put(4, "Thuesday");
		map.put(5, "Friday");
		map.put(6, "Saturday");
		map.put(7, "Monday");
		
		
		System.out.println(year+"��"+month+"��"+day+"��"+map.get(week));
	}

}
