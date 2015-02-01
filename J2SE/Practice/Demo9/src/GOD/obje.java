package GOD;
/*2013年5月9日11:39:04
 * 学习覆盖equals
 * 为什么要抛运行
 * 1:父类没有异常
 * 2:此类错误必须马上停止和只有调用者才知道这个异常.
 * 
 * 覆盖equals的时候是需要重写hashCode的,这个时候需要地址与内容相同!
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
		
		if(!(b instanceof obje))throw new ClassCastException("HI,类型异常了");
		obje o=(obje)b;
		return this.name==o.name;
		
	}
	public int hashCode()//重写类的hash地址
		{
			text=8;
			return text;
		}
	public String toString()//返回类对象特有TOstring方法
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
