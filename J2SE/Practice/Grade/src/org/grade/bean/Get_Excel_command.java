package org.grade.bean;

public class Get_Excel_command {
	private static int intRow;
	private static int intCol;//变量数
	private static double[][] XY;//存放数据
	
	public static int getIntRow() {
		return intRow;
	}
	public static int getIntCol() {
		return intCol;
	}

	public static void setIntRow(int intRow) {
		Get_Excel_command.intRow = intRow;
	}
	public static void setIntCol(int intCol) {
		Get_Excel_command.intCol = intCol;
	}
	public static double[][] getXY() {
		return XY;
	}
	public static void setXY(double[][] xY) {
		XY = xY;
	}
	
	
	
	
}
