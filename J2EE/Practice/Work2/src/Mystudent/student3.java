package Mystudent;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class student3 {
    private int age;
	private List<studentlisten> list;

	public List<studentlisten> getList() {
		return list;
	}
	public void setList(List<studentlisten> list) {
		this.list = list;
	}
	public student3()
	{
		list=new ArrayList<studentlisten>();
	}
	public void addlisten(studentlisten sl)
	{
		if(sl!=null)
			list.add(sl);
	}
	public void removelisten(studentlisten sl)
	{
		if(sl!=null)
		list.remove(sl);
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
		if(this.age>=30)
		{
			student s=new student(this, "年龄大于30");//产生事件对象
			Iterator<studentlisten> it=list.iterator();
			while(it.hasNext())
			{
				studentlisten sl=it.next();
				sl.checkmsg(s);
			}
		}
	}

  public  static void main(String []args)
  {
	  student3 s3=new student3();
	  s3.addlisten(new studentlisten() {
		
		public void checkmsg(student s) {
			// TODO Auto-generated method stub
			System.out.println(s.getMsg());
		}
	});
	  s3.setAge(50);
	  
  }
}
