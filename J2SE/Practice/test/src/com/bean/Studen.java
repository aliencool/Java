package com.bean;

public class Studen {
	private int stuid;
	private String name;
	private int age;
	private String gender;
	private int []result;
	
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int[] getResult() {
		return result;
	}
	public void setResult(int[] result) {
		this.result = result;
	}
	public Studen(int stuid, String name, int age, String gender, int[] result) {
		super();
		this.stuid = stuid;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.result = result;
	}

	public Studen() {
		super();
	}
	
	
	
}
