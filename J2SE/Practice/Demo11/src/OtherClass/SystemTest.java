package OtherClass;
/*2013��8��8��17:34:14
 * ѧϰSystem ȫ�Ǿ�̬��
 * properties:���ֻ�ȡ(ֻ�� Propertiers��ȡ����get)
 * SetProperty:��������
 * */
import java.util.*;

public class SystemTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello"+System.getProperty("os.version")+"World");
		
		
		System.setProperty("haha", "heihei");//�Զ���������
		System.out.println("Hello"+System.getProperty("haha")+"World");
		
		
		Properties pp=System.getProperties();
		Set<String> set=pp.stringPropertyNames();
		
		for(String key:set)
		{
			System.out.println(key+"::"+pp.getProperty(key));
		}
		
		
	}

}
