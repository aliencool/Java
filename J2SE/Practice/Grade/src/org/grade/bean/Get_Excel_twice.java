package org.grade.bean;

public class Get_Excel_twice {
		//����A�������
		private static int A_row;
		//����B�������
		private static int B_row;
		//��������������
		private static int C_row;
		//����A�������
		private static double[][] X1=new double[getA_row()+1][4];
		//����B�������
		private static double[][] X2=new double[getB_row()+1][4];
		//����C�������
		private static double[][] X3=new double[getB_row()+1][4];
		public static int getA_row() {
			return A_row;
		}
		public static int getB_row() {
			return B_row;
		}
		public static double[][] getX1() {
			return X1;
		}
		public static double[][] getX2() {
			return X2;
		}
		public static void setA_row(int aRow) {
			A_row = aRow;
		}
		public static void setB_row(int bRow) {
			B_row = bRow;
		}
		public static void setX1(double[][] x1) {
			X1 = x1;
		}
		public static void setX2(double[][] x2) {
			X2 = x2;
		}
		public static int getC_row() {
			return C_row;
		}
		public static void setC_row(int cRow) {
			C_row = cRow;
		}
		public static double[][] getX3() {
			return X3;
		}
		public static void setX3(double[][] x3) {
			X3 = x3;
		}
		
		
		
		
}
