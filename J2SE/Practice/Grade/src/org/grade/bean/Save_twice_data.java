package org.grade.bean;

import java.util.Map;

/*ר��������ʾ����*/
public class Save_twice_data {
	//�б�mess
	private  String message;
	//�����ŵ��˹����
	private  double mh;
	//FУ��ֵ
	private  double FF;
	//F001
	private  double Fone;
	//F005
	private  double Five;
	//ԭ��
	private Map<Integer,String> origin;
	//����
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
