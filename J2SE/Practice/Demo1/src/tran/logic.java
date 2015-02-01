package tran;

public class logic {
	//定义为全局:
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		complute();
	}
	
	
	public static void lnGamma(double X, double G) {
	     double Y,  z,  a;
	     double b,  b1;
	     int n;
	     int I;
	    if ( X < 8 ) {
	        Y = X + 8;
	        n = -1;
	    } else {
	        Y = X;
	        n = 1;
	    }
	    z = 1 / (Y * Y);
	    a = (Y - 0.5) * Math.log(Y) - Y + 0.9189385;
	    b1 = (0.0007663452 * z - 0.0005940956) * z;
	    b1 = (b1 + 0.0007936431) * z;
	    b1 = (b1 - 0.002777778) * z;
	    b = (b1 + 0.0833333) / Y;
	    G = a + b;
	    if ( n >= 0 ) {
	    	return; 
	    }
	    Y = Y - 1;
	    a = Y;
	    for ( I = 1 ; I <= 7;I++)
	        a = a * (Y - I);
	     // I
	    G = G - Math.log(a);
	}
	
	public static void PNorm(double Q,double X) {
		double p = 0;
		double Y = 0;
		double z = 0;
		double b0 = 0;
		double b1 = 0;
		double b2 = 0;
		double b3 = 0;
		double b4 = 0;
		double b5 = 0;
		double b6 = 0;
		double b7 = 0;
		double b8 = 0;
		double b9 = 0;
		double b10 = 0;
		double b = 0;
		b0 = 1.570796288;
		b1 = 0.03706987906;
		b2 = -0.0008364353589;
		b3 = -0.0002250947176;
		b4 = 0.000006841218299;
		b5 = 0.000005824238515;
		b6 = -0.00000104527497;
	    if ( Q ==0.5 ) {
	        X = 0;
	        return;
	    }
	    if ( Q > 0.5 ) { 
	    	p = 1 - Q;
	    	}
	    else { 
	    	p = Q;
	    }
	    Y = -Math.log(4 * p * (1 - p));
	    b = Y * (b9 + Y * b10);
	    b = Y * (b8 + b);
	    b = Y * (b7 + b);
	    b = Y * (b6 + b); 
	    b = Y * (b5 + b);
	    b = Y * (b4 + b);
	    b = Y * (b3 + b);
	    b = Y * (b2 + b); 
	    b = Y * (b1 + b);
	    z = Y * (b0 + b);
	    X = Math.sqrt(z);
	    if ( Q > 0.5 ) { X = -X;}  
	    
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
			return;
		}
		X = N1 * F / (N2 + N1 * F);
		if ((N1 / 2) * 2 == N1)
		{
			if ((N2 / 2) * 2 == N2)
			{
				U = X * (1 - X);
				p = X;
				IAI = 2;
				IBI = 2;
			}
			else
			{
				U = X * Math.sqrt(1 - X) / 2;
				p = 1 - Math.sqrt(1 - X);
				IAI = 2;
				IBI = 1;
			}
		}
		else
		{
			if ((N2 / 2) * 2 == N2)
			{
				p = Math.sqrt(X);
				U = p * (1 - X) / 2;
				IAI = 1;
				IBI = 2;
			}
			else
			{
				U = Math.sqrt(X * (1 - X))/PI;
				p = 1 - 2 * Math.atan(Math.sqrt((1 - X) / X)) / PI;
				IAI = 1;
				IBI = 1;
			}
		}
		nn1 = N1 - 2;
		nn2 = N2 - 2;
		if (U == 0)
		{
			D = U / F;
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
				return;
			}
			for (I = IBI; I <= nn2; I += 2)
			{
				p = p + 2 * U / I;
				Lu = Lu + Math.log((1 + N1 / I) * (1 - X));
				U = Math.exp(Lu);
			}
			D = U / F;
		}
		for (I = IAI; I <= nn1; I += 2)
		{
			p = p - 2 * U / I;
			Lu = Lu + Math.log((1 + IBI / I) * X);
			U = Math.exp(Lu);
		}
	
	}
	
	

	
	public static void PF_DIST(int N1, int N2, double Q, double F)
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
		DF12 = N1 / 2;
		DF22 = N2 / 2;
		a = 2 / (9 * N1) ;
		A1 = 1 - a;
		b = 2 / (9 * N2) ;
		b1 = 1 - b;
		p = 1 - Q;
		PNorm (Q, YQ);
		E = b1 * b1 - b * YQ * YQ;
		
		if (E > 0.8)
		{
			FO = Math.pow(((A1 * b1 + YQ * Math.sqrt(A1 * A1 * b + a * E)) / E), 3);
		}
		else
		{
			lnGamma (DF12 + DF22, GA1);
			lnGamma (DF12, GA2);
			lnGamma (DF22, GA3);
			FO = (2 / N2) * (GA1 - GA2 - GA3 + 0.69315 + (DF22 - 1) * Math.log(N2) 
				- DF22 * Math.log(N1) - Math.log(Q));
			FO = Math.exp(FO);
		}
		for (K = 1; K <= 30; K++)
		{
			F_DIST (N1, N2, FO, pp, D);
			if (D == 0)
			{
				F = FO;
				return;
			}
			F = FO - (pp - p) / D;
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
	
	public static void Invert(double a[][]) {

		int n;
		double ep;
		int I;
		int J;
		int K;
		int I0 = 0;
		int J0 = 0;
		double w;
		double z;
		double[] b = new double[101];
		double[] c = new double[101];
		double[] p = new double[101];
		double[] Q = new double[101];
		n = a.length - 1;

		ep = 0.0000000001;
		for (K = 1; K <= n; K++)
		{
			w = 0;
			for (I = K; I <= n; I++)
			{
				for (J = K; J <= n; J++)
				{
					if (Math.abs(a[I][J]) > Math.abs(w))
					{
						w = a[I][J] ;
						I0 = I;
						J0 = J;
					}
				}
			}
			if (Math.abs(w) < ep)
			{
				System.out.println("全主元素的绝对值小于0.0000000001，矩阵是奇异的！");
				return;
			}
			if (I0 != K)
			{
				for (J = 1; J <= n; J++)
				{
					z = a[I0][J] ;
					a[I0][J] = a[K][J];
					a[K][J] = z;
				}
			}
			if (J0 != K)
			{
				for (I = 1; I <= n; I++)
				{
					z = a[I][J0];
					a[I][J0] = a[I][K] ;
					a[I][K] = z;
				}
			}
			p[K] = I0;
			Q[K] = J0;
			for (J = 1; J <= n; J++)
			{
				if (J == K)
				{
					b[J] = 1 / w;
					c[J] = 1;
				}
				else
				{
					b[J] = - a[K][J] / w;
					c[J] = a[J][K];
				}
				a[K][J] = 0;
				a[J][K] = 0;
			}
			for (I = 1; I <= n; I++)
			{
				for (J = 1; J <= n; J++)
				{
					a[I][J] = a[I][J] + c[I] * b[J];
				}
			}
		}
		for (K = n; K >= 1; K--)
		{
			I0 =(int) (p[K]);
			J0 = (int) (Q[K]);
			if (I0 != K)
			{
				for (I = 1; I <= n; I++)
				{
					z = a[I][I0];
					a[I][I0] = a[I][K] ;
					a[I][K] = z;
				}
			}
			if (J0 != K)
			{
				for (J = 1; J <= n; J++)
				{
					z = a[J0][J];
					a[J0][J] = a[K][J] ;
					a[K][J] = z;
				}
			}
		}// K
	}
	
	public static void complute()
	{
		//M:列
		int M=3;
		int J,I,M1,K;
		double S1=0,S2,FF,F005 = 0,F001 = 0;
		//A
		int N1=2;
		int N2=4;
		
		//
		
		double [] Y1 = new double [N1+1]; //保存样本判别值
		double [] Y2 = new double [N2+1];
		
		double []CP1=new double[M+1];
		double []CP2=new double[M+1];
		double [][]XS=new double[M+1][M+1];
		double  []DD=new double[M+1];
		double   []CC=new double[M+1];
		
		double [][]X1=new double[N1+1][M+1];
		X1[1][1]=2.98;
		X1[1][2]=0.31;
		X1[1][3]=0.53;
		
		X1[2][1]=3.20;
		X1[2][2]=0.53;
		X1[2][3]=0.77;
		
		
		double [][]X2=new double[N2+1][M+1];
		X2[1][1]=2.53;
		X2[1][2]=0.47;
		X2[1][3]=0.49;
		
		X2[2][1]=2.59;
		X2[2][2]=0.30;
		X2[2][3]=0.27;
		
		X2[3][1]=2.96;
		X2[3][2]=3.05;
		X2[3][3]=1.50;
		
		X2[4][1]=3.12;
		X2[4][2]=2.84;
		X2[4][3]=1.99;
		
		
		
	
		
		//平均值
		for (J = 1; J <= M; J++)
		{
			S1 = 0;
			for (I = 1; I <= N1; I++)
			{
				
				S1 = S1 + X1[I][J];
			}
		
			CP1[J] = S1 / N1; //A组样本的变量平均值
			S1 = 0;
			for (I = 1; I <= N2; I++)
			{
				S1 = S1 + X2[I][J];
			}
			CP2[J] = S1 / N2; //B组样本的变量平均值
		}
		
		//计算判别方程的系数矩阵XS
		M1 = M + 1;
		for (I = 1; I <=M; I++)
		{
			for (J = 1; J <=M; J++)
			{
				S1 = 0;
				S2 = 0;
				for (K = 1; K <= N1; K++)
				{
					S1 = S1 + (X1[K][I] - CP1[I]) * (X1[K][J] - CP1[J]);
				}
				for (K = 1; K <= N2; K++)
				{
					S2 = S2 + (X2[K][ I] - CP2[I]) * (X2[K][J] - CP2[J]);
				}
				
				XS[I][J] = S1 + S2;
				
			}
	
		}
		for (I = 1; I <= M; I++)
		{
			DD[I] = CP1[I] - CP2[I]; //求判别方程时的右侧向量
			
		}
	
		
		
		
		//解线性代数方程组
		Invert(XS); //矩阵求逆
		
		
		
		for (I = 1; I <= M; I++)
		{
			for (J = 1; J <= M; J++)
			{
				//DD是线性代数方程组的右侧向量。CC是求出的判别方程系数
				CC[I] = CC[I] + XS[I][J] * DD[J];
			}
		}
		double D2 = 0;
		for (I = 1; I <= M; I++)
		{
			D2 = D2 + (CP1[I] - CP2[I]) * CC[I];
		}
		D2 = ((N1 + N2) - 2) * D2; //马哈拉诺比斯距离
		
		
		//F检验值
		FF = D2 * (N1 * N2 * (N1 + N2 - M - 1)) / ((N1 + N2) * ((N1 + N2) - 2) * M);
		
		int UA = M;
		int Ue = N1 + N2 - M - 1;
		PF_DIST (UA, Ue, 0.05, F005); //计算显著性为0.05的F临界值
		PF_DIST (UA, Ue, 0.01, F001); //计算显著性为0.01的F临界值
		System.out.println(F005);
	
		if (FF <= F005)
		{
			System.out.println( "判别方程的意义不显著");
		}
		if (FF > F005 && FF <= F001)
		{
			System.out.println( "判别方程的意义显著");
		}
		if (FF > F001)
		{
			System.out.println( "判别方程的特别显著");
		}
		
		//根据判别方程计算每个样本的判别值
		for (I = 1; I <= N1; I++)
		{
			Y1[I] = 0;
			for (J = 1; J <= M; J++)
			{
				//Y1为A组样本的判别值
				Y1[I] = Y1[I] + X1[I][J] * CC[J];
			}
			System.out.println("Y1:"+Y1[I]);
		}
		for (I = 1; I <= N2; I++)
		{
			Y2[I] = 0;
			for (J = 1; J <= M; J++)
			{
				//Y2为B组样本的判别值
				Y2[I] = Y2[I] + X2[I][J] * CC[J];
			}
			System.out.println("Y2:"+Y2[I]);
		}
	
		
		
		
	}
	
	
	}
