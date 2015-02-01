package org.grade.bean;

import java.util.Map;

/*专门用来显示数据*/
public class Save_twice_data {
	//判别mess
	private  String message;
	//马哈拉诺比斯距离
	private  double mh;
	//F校检值
	private  double FF;
	//F001
	private  double Fone;
	//F005
	private  double Five;
	//原有
	private Map<Integer,String> origin;
	//个数
	private int count;
	
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getMessage() {
		return message;
	}
	public double getMh() {
		return mh;
	}
	public double getFF() {
		return FF;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	public void setMh(double mh) {
		this.mh = mh;
	}
	public void setFF(double fF) {
		FF = fF;
	}
	public double getFone() {
		return Fone;
	}
	public double getFive() {
		return Five;
	}
	public void setFone(double fone) {
		Fone = fone;
	}
	public void setFive(double five) {
		Five = five;
	}
	public Map<Integer, String> getOrigin() {
		return origin;
	}
	public void setOrigin(Map<Integer, String> origin) {
		this.origin = origin;
	}

	

	
	
}
