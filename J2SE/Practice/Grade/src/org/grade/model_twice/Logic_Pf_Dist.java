package org.grade.model_twice;

public class Logic_Pf_Dist {
	private static double F005;
	private static double F001;
	
	
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


	public static void PF_DIST_F001(int N1, int N2, double Q, double F)
	{
		double DF12 = 0;
		double DF22 = 0;
		double a = 0;
		double b = 0;
		double A1 = 0;
		double b1 = 0;
		double p = 0;
		double YQ = 0;
		double E = 0;
		double FO = 0;
		double pp = 0;
		double D = 0;
		double GA1 = 0;
		double GA2 = 0;
		double GA3 = 0;
		int K = 0;
		DF12 = (double)N1 / 2;
		DF22 = (double)N2 / 2;
		a = (double)2 / (9 * N1) ;
		A1 = 1 - a;
		b = (double)2 / (9 * N2) ;
		b1 = 1 - b;
		p = 1 - Q;
	
		
		Logic_Pnorm.Pnorm(Q, YQ);
	
		E = b1 * b1 - b * Logic_Pnorm.getYQ() * Logic_Pnorm.getYQ();
	
		if (E > 0.8)
		{
			FO = Math.pow(((A1 * b1 + Logic_Pnorm.getYQ() * Math.sqrt(A1 * A1 * b + a * E)) / E), 3);
		}
		else
		{
			Logic_lnGamma.lnGamma_GA1(DF12 + DF22, GA1);
			Logic_lnGamma.lnGamma_GA2(DF12, GA2);
			Logic_lnGamma.lnGamma_GA3(DF22, GA3);
			
			FO = (2 / N2) * (Logic_lnGamma.getGA1() - Logic_lnGamma.getGA2() - Logic_lnGamma.getGA3() + 0.69315 + (DF22 - 1) * Math.log(N2) 
				- DF22 * Math.log(N1) - Math.log(Q));
			FO = Math.exp(FO);
		}
		for (K = 1; K <= 30; K++)
		{
			Logic_F_Dist.F_DIST(N1, N2, FO, pp, D);
			if (D == 0)
			{
				F = FO;
				setF001(F);
				return;
			}
			F = FO - (Logic_F_Dist.getPP() - p) / Logic_F_Dist.getD();
			setF001(F);
			
			if (Math.abs(FO - F) < 0.000001 * Math.abs(F))
			{
				return;
			}
			else
			{
				FO = F;
			}
		}
	}
	
	
	public static void PF_DIST_F005(int N1, int N2, double Q, double F)
	{
		double DF12 = 0;
		double DF22 = 0;
		double a = 0;
		double b = 0;
		double A1 = 0;
		double b1 = 0;
		double p = 0;
		double YQ = 0;
		double E = 0;
		double FO = 0;
		double pp = 0;
		double D = 0;
		double GA1 = 0;
		double GA2 = 0;
		double GA3 = 0;
		int K = 0;
		DF12 = (double)N1 / 2;
		DF22 = (double)N2 / 2;
		a = (double)2 / (9 * N1) ;
		A1 = 1 - a;
		b = (double)2 / (9 * N2) ;
		b1 = 1 - b;
		p = 1 - Q;
		
		Logic_Pnorm.Pnorm(Q, YQ);
		E = b1 * b1 - b * Logic_Pnorm.getYQ() * Logic_Pnorm.getYQ();
		
		if (E > 0.8)
		{
			FO = Math.pow(((A1 * b1 + Logic_Pnorm.getYQ() * Math.sqrt(A1 * A1 * b + a * E)) / E), 3);
		}
		else
		{
			Logic_lnGamma.lnGamma_GA1(DF12 + DF22, GA1);
			Logic_lnGamma.lnGamma_GA2(DF12, GA2);
			Logic_lnGamma.lnGamma_GA3(DF22, GA3);
			
			FO = (2 / N2) * (Logic_lnGamma.getGA1() - Logic_lnGamma.getGA2() - Logic_lnGamma.getGA3() + 0.69315 + (DF22 - 1) * Math.log(N2) 
				- DF22 * Math.log(N1) - Math.log(Q));
			FO = Math.exp(FO);
		}
		for (K = 1; K <= 30; K++)
		{
			Logic_F_Dist.F_DIST(N1, N2, FO, pp, D);
			if (D == 0)
			{
				F = FO;
				setF005(F);
				return;
			}
			F = FO - (Logic_F_Dist.getPP() - p) / Logic_F_Dist.getD();
			setF005(F);
			if (Math.abs(FO - F) < 0.000001 * Math.abs(F))
			{
				return;
			}
			else
			{
				FO = F;
			}
		}
	}
}
