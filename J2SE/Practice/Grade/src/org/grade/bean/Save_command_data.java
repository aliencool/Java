package org.grade.bean;

public class Save_command_data {
	private  double [][] New_Sort;
	//����
	private int count;
	//������ʾ����
	public  double[][] getNew_Sort() {
		return New_Sort;
	}

	public  void setNew_Sort(double[][] newSort) {
		New_Sort = newSort;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
