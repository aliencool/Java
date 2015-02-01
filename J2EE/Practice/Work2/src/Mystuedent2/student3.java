package Mystuedent2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;




/*2013年9月27日15:02:47
 *Bean 
 * */



public class student3 {
	private String university;
	private PropertyChangeSupport pcs;
	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		
		  String olduniversity=this.university;
		  this.university=university;
		  pcs.firePropertyChange("university",olduniversity, this.university);
	}

	public PropertyChangeSupport getPcs() {
		return pcs;
	}

	public void setPcs(PropertyChangeSupport pcs) {
		this.pcs = pcs;
	}

	public student3()
	{
		
		pcs=new PropertyChangeSupport(this);
		this.university="gk";
	}
		
	  
	
	public void addlistenproperty(PropertyChangeListener pcl)
	{
		pcs.addPropertyChangeListener(pcl);
	}
	public void removelistenproperty(PropertyChangeListener pcl)
	{
		pcs.removePropertyChangeListener(pcl);
	}



	public static void main(String[] args) {
		student3 s3=new student3();
		
		s3.addlistenproperty(new PropertyChangeListener() {
			
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				System.out.println("更改前为:"+evt.getOldValue());
				System.out.println("更改后为:"+evt.getNewValue());
			}
		});
	 s3.setUniversity("hr");
		
	}

}
