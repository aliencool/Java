package GOD;
/*2013��5��9��11:39:04
 * ѧϰ����equals
 * ΪʲôҪ������
 * 1:����û���쳣
 * 2:��������������ֹͣ��ֻ�е����߲�֪������쳣.
 * 
 * ����equals��ʱ������Ҫ��дhashCode��,���ʱ����Ҫ��ַ��������ͬ!
 * */
class A{}
public class obje {
    private String name;
    private int  text;
	/**
	 * @param args
	 */
	public boolean  equals(Object b)
	{
		
		if(!(b instanceof obje))throw new ClassCastException("HI,�����쳣��");
		obje o=(obje)b;
		return this.name==o.name;
		
	}
	public int hashCode()//��д���hash��ַ
		{
			text=8;
			return text;
		}
	public String toString()//�������������TOstring����
	{
		return "Person"+name;//getClass().getName()+"@"+Inter.toHex(.hashCode());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		obje o=new obje();
		Class s=o.getClass();
		
		System.out.println(s.getConstructors());
		
		System.out.println(o);
		System.out.println(o.hashCode());
		

	}

}
