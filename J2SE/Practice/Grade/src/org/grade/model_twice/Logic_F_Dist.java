package org.grade.model_twice;

public class Logic_F_Dist {
	
	private static double PP;
	private static double D;

	public static double getPP() {
		return PP;
	}
	public static double getD() {
		return D;
	}
	
	public static void setPP(double pP) {
		PP = pP;
	}
	public static void setD(double d) {
		D = d;
	}
	
	
	public static void F_DIST(int N1, int N2, double F, double p, double D)
	{
		double X = 0;
		double U = 0;
		double Lu = 0;
		int IAI = 0;
		int IBI = 0;
		int nn1 = 0;
		int nn2 = 0;
		int I = 0;
		final double PI = 3.14159265359;
		if (F == 0)
		{
			p = 0;
			D = 0;
			setD(D);
			setPP(p);
			return;
		}
		X = N1 * F / (N2 + N1 * F);
		if ((N1 / 2) * 2 == N1)
		{
			if ((N2 / 2) * 2 == N2)
			{
				U = X * (1 - X);
				p = X;
				setPP(p);
				IAI = 2;
				IBI = 2;
			}
			else
			{
				U = X * Math.sqrt(1 - X) / 2;
				p = 1 - Math.sqrt(1 - X);
				setPP(p);
				IAI = 2;
				IBI = 1;
			}
		}
		else
		{
			if ((N2 / 2) * 2 == N2)
			{
				p = Math.sqrt(X);
				setPP(p);
				U = p * (1 - X) / 2;
				IAI = 1;
				IBI = 2;
			}
			else
			{
				U = Math.sqrt(X * (1 - X))/PI;
				p = 1 - 2 * Math.atan(Math.sqrt((1 - X) / X)) / PI;
				setPP(p);
				IAI = 1;
				IBI = 1;
			}
		}
		nn1 = N1 - 2;
		nn2 = N2 - 2;
		if (U == 0)
		{
			D = U / F;
			setD(D);
			return;
		}
		else
		{
			Lu = Math.log(U);
		}
		if (IAI == N1)
		{
			if (IBI == N2)
			{
				D = U / F;
				setD(D);
				return;
			}
			for (I = IBI; I <= nn2; I += 2)
			{
				p = p + 2 * U / I;
				setPP(p);
				Lu = Lu + Math.log((1 + N1 / I) * (1 - X));
				U = Math.exp(Lu);
			}
			D = U / F;
			setD(D);
		}
		for (I = IAI; I <= nn1; I += 2)
		{
			p = p - 2 * U / I;
			setPP(p);
			Lu = Lu + Math.log((1 + IBI / I) * X);
			U = Math.exp(Lu);
		}
	
	}

}
