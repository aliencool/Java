package cn.ccc.bean;

public class Teacher extends Person{
	private String no;
	private double salary;
	public String getNo() {
		return no;
	}
	public double getSalary() {
		return salary;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
