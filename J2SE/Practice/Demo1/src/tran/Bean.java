package tran;

public final class Bean {
	//数据文件不能被创建
	private Bean(){}
	private static double F005;
	private  static double F001;
	private static double Q;
	private static double YQ;
	private static double DF12;
	private static double DF22;
	private static double GA1;
	private static double GA2;
	private static double GA3;
	private static double FO;
	private static double pp;
	private static double D;
	
	
	
	
	public static double getFO() {
		return FO;
	}
	public static double getPp() {
		return pp;
	}
	public static double getD() {
		return D;
	}
	public static void setFO(double fO) {
		FO = fO;
	}
	public static void setPp(double pp) {
		Bean.pp = pp;
	}
	public static void setD(double d) {
		D = d;
	}
	public static double getGA1() {
		return GA1;
	}
	public static double getGA2() {
		return GA2;
	}
	public static double getGA3() {
		return GA3;
	}
	public static void setGA1(double gA1) {
		GA1 = gA1;
	}
	public static void setGA2(double gA2) {
		GA2 = gA2;
	}
	public static void setGA3(double gA3) {
		GA3 = gA3;
	}
	public static double getDF12() {
		return DF12;
	}
	public static double getDF22() {
		return DF22;
	}
	public static void setDF12(double dF12) {
		DF12 = dF12;
	}
	public static void setDF22(double dF22) {
		DF22 = dF22;
	}
	public static double getYQ() {
		return YQ;
	}
	public static void setYQ(double yQ) {
		YQ = yQ;
	}
	public static double getQ() {
		return Q;
	}
	public static void setQ(double q) {
		Q = q;
	}
	
	public static double getF005() {
		return F005;
	}
	public static double getF001() {
		return F001;
	}
	public static void setF005(double f005) {
		F005 = f005;
	}
	public static void setF001(double f001) {
		F001 = f001;
	}
	
	
	
}
