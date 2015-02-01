package extends1;/*
学习抽象（自低向上）
*/
abstract class Person{
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	private String name;
	private int    age;
	private String sex;
	Person(String n,int a,String s)
	{
		this.name=n;
		this.age=a;
		this.sex=s;
	}
	abstract void goods();
}

class gk extends Person
{
	gk(String n,int a,String s){super(n,a,s);}
	void goods(){
		System.out.println("Buy.........."+getName()+"................."+getSex());
	};
}


public class abstrcat1  {
  
   
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gk g=new gk("zs",88,"b");
		g.goods();
		gk g1=new gk("ls",88,"b");
		g1.goods();
		
	}

}
