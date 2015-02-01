package Mystuedent2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

public class student4 {

	/**
	 * @param args
	 */
	private int age=0;
	private VetoableChangeSupport vcs;
	
	student4()
	{
		vcs=new VetoableChangeSupport(this);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		 int oldage=this.age;
		   
		   this.age=age;
		try
		{
			vcs.fireVetoableChange("age", oldage, age);
		}
		catch(PropertyVetoException e)
		{
			
			System.out.println(e);
		}
	}
	public void addlisten(VetoableChangeListener vcl)
	{
		vcs.addVetoableChangeListener(vcl);
	}
	public void removelisten(VetoableChangeListener vcl)
	{
		vcs.removeVetoableChangeListener(vcl);
	}
	
	public VetoableChangeSupport getVcs() {
		return vcs;
	}
	public void setVcs(VetoableChangeSupport vcs) {
		this.vcs = vcs;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		student4 s4=new student4();
		
		s4.addlisten(new VetoableChangeListener() {
			
			public void vetoableChange(PropertyChangeEvent evt)
					throws PropertyVetoException {
			if(Integer.parseInt(evt.getNewValue().toString())<=20)
			{
				PropertyVetoException pv= new PropertyVetoException("ÄêÁäµÍÓÚ20", evt);
				throw  pv;
			}
				
			}
		});

		s4.setAge(19);
	}

}
