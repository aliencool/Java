package org.grade.model_command;

import org.grade.bean.Get_Excel_command;
import org.grade.bean.Save_command;
import org.grade.bean.Save_command_data;

public class Logic_CalCoeD2 {
	//逐步判别所需的变量和数组
	//行就是行 列就是列 G分类数
	
	private static int intRow=Get_Excel_command.getIntRow()-1;
	private static int intCol=Get_Excel_command.getIntCol()-1;//变量数
	private static int N = intRow;//样本总数
	private static int M = intCol - 1;
	private static int G=3; //分类数
	private static int L; //最终选中的变量个数
	private static double[] Q=new double[G+1]; //先验概率
	private static double[][] XY; //观测数据
	private static double[][] Mx=new double[G+2][M+1]; //平均值
	private static double[] Ng=new double[G+1]; //各种分类的样本数
	private static double[][] C=new double[G+1][M+1]; //判别系数
	private static double[] D2gh=new double[(G-1)*G/2+1]; //马哈拉诺比斯距离
	private static double[] Fhg=new double[(G-1)*G/2+1]; //F检验值
	private static double[][] Dm=new double[G+2][G+2]; //判别矩阵
	private static double[][] W=new double[M+1][M+1]; //组内离差矩阵
	private static double[][] T=new double[M+1][M+1]; //总离差矩阵
	private static double[] X=new double[M+1]; //记录变量是否被选中
	private static double[] LnQ=new double[G+1]; //计算判别函数的中间结果
	private static double[] Pr=new double[G+1]; //保存计算后验概率的中间结果
	private static double[][] New_Sort=new double[N+2][5]; //新分类和后验概率
	
	
	

	private static void CalCoeD2(int N, int L, double[] X, double[][] W, double[][] Mx, double[][] C, double[] D2hg, double[] Ng, double[] Fhg)
	{
		double C0 = 0;
		double Ci = 0;
		double D2 = 0;
		int D = 0;
		int I = 0;
		int J = 0;
		int K = 0;
		int H = 0;
		int G = 0;
		int M = 0;
		G =	Ng.length - 1;
		M = X.length - 1; //G是分类数，M是变量数
		for (H = 1; H <= G; H++)
		{
			C0 = 0;
			for (I = 1; I <= M; I++)
			{
				Ci = 0;
				//X(i) = 0 表示为未选量，否则已选
				if (X[I] != 0)
				{
					for (J = 1; J <= M; J++)
					{
						if (X[J] != 0)
						{
							Ci = Ci + W[I][J] * Mx[H][J];
						}
					}
				}
				C[H][I] = (double)((N - G) * Ci);
				C0 = C0 + Ci * Mx[H][I];
			}
			C[H][0] = (double)(- C0 * (N - G) / 2);
		}
		D = 0;
		for (H = 2; H <= G; H++)
		{
			for (K = 1; K <= H - 1; K++)
			{
				D = D + 1;
				D2 = 0;
				for (I = 1; I <= M; I++)
				{
					if (X[I] != 0)
					{
						D2 = D2 + (C[H][I] - C[K][I]) * (Mx[H][I] - Mx[K][I]);
					}
					
					D2hg[D] = D2; //马哈拉诺比斯距离
					Fhg[D] = D2 * ((N - G - L + 1) * Ng[H] * Ng[K] / (L * (N - G) * (Ng[H] + Ng[K]))); //F检验值
				}
			}
		}
	}

	private static void Cla(double[][] XY, double[] X, double[][] C, double[] LnQ, double[] Pr, double[][] Dm, double[][] New_Sort)
	{
		int I;
		int J;
		int K;
		int H;
		int N;
		int M;
		int M1;
		int G;
		int G1;
		double Yh;
		double Ymax;
		double Hmax=0;
		double D;
		double D1;
		double D2;
		N = XY.length - 1;
		G = C.length - 1;
		M = X.length - 1;
		M1 = M + 1;
		G1 = G + 1;
		for (K = 1; K <= N; K++)
		{
			Ymax = -1000000;
			for (H = 1; H <= G; H++)
			{
				Yh = (double)(LnQ[H] + C[H][0]);
				for (I = 1; I <= M; I++)
				{
					if (X[I] != 0)
					{
						Yh = Yh + C[H][I] * XY[K][I];
					}
				}
				Pr[H] = Yh; //判别函数
				if (Yh > Ymax)
				{
					Ymax = (double)Yh;
					Hmax = H;
				}
			}
			D = 0;
			for (H = 1; H <= G; H++)
			{
				Pr[H] = Math.exp(Pr[H] - Ymax);
				D = D + Pr[H];
			}
			Ymax = (double)Pr[(int)Hmax] / D; //后验概率
			H = (int) XY[K][M1]; //原来分类
			Dm[(int)Hmax][H] = Dm[(int)Hmax][H] + 1; //形成判别矩阵
			// "原来分类" = H, "新分类" = Hmax, "后验概率" = Ymax
			
			New_Sort[K][1] = H;
			System.out.println(K);
			New_Sort[K][2] = Hmax;
			
			New_Sort[K][3] = Ymax;
		}
		for (H = 1; H <= G; H++)
		{
			D1 = 0;
			D2 = 0;
			for (K = 1; K <= G; K++)
			{
				D1 = D1 + Dm[H][K];
				D2 = D2 + Dm[K][H];
			}
			Dm[H][G1] = D1;
			Dm[G1][H] = D2;
		}
		Dm[G1][G1] = N;
	}
	
	

	public static  void complute(Save_command_data commandData) {
		// TODO Auto-generated method stub
		
		//普通定义:
		int G1;
		int M1;
		int H;
		int Step;
		int Imin = 0;
		int Imax = 0;
		int R = 0;
		int I,J,K;
		int R12;
		double D;
		double D1;
		double eps;
		double Umax;
		double Umin;
		double Ui = 0;
		double U;
		double X2;
		double F12;
		double F1 = 0;
		double F2 = 0;
		
		
		//测试数据
		XY = Get_Excel_command.getXY(); 
	
		
		
		//函数显示数据区
		G1 = G + 1;
		M1 = M + 1;

		for (I = 1; I <= G; I++)
		{
		
			Ng[I] = 0;
		}
		for (I = 1; I <= G1; I++)
		{
			for (J = 1; J <= M; J++)
			{
				
				Mx[I][J] = 0;
			}
		}
		for (K = 1; K <= N; K++)
		{
			H=(int)XY[K][M1];
			System.out.println(XY[K][M1]+"K="+K+"M="+M1);
			if ((H - 1) * (H - G) > 0)
			{
				System.out.println("原分类错，修改后重作");
				return;
			}
			Ng[H] = Ng[H] + 1; //Ng为各种分类的样本数
			for (I = 1; I <= M; I++)
			{
				Mx[H][I] = XY[K][I] + Mx[H][I];
			}
		}
		for (I = 1; I <= M; I++)
		{
			D = 0;
			for (H = 1; H <= G; H++)
			{
				D = D + Mx[H][I];
				Mx[H][I] = Mx[H][I] / Ng[H]; //平均值
			}
			Mx[G1][I] = D / N; //总平均值
		}
		for (I = 1; I <= M; I++)
		{
			for (J = 1; J <= M; J++)
			{
				T[I][J] = 0;
				W[I][J] = 0;
			}
		}
		for (K = 1; K <= N; K++)
		{
			for (I = 1; I <= M; I++)
			{
				D = XY[K][I] - Mx[G1][I];
				X[I] = D;
				for (J = 1; J <= I; J++)
				{
					T[I][J] = D * X[J] + T[I][J]; //总离差矩阵
				}
			}
		}
		for (H = 1; H <= G; H++)
		{
			D = Ng[H];
			for (I = 1; I <= M; I++)
			{
				D1 = Mx[H][I] - Mx[G1][I];
				X[I] = D * D1;
				for (J = 1; J <= I; J++)
				{
					W[I][J] = D1 * X[J] + W[I][J]; //组间离差 B，先置于 W 的下三角
				}
			}
		}
		//计算组内离差矩阵 W = T - B，并把 W、T 补成方阵
		for (I = 1; I <= M; I++)
		{
			for (J = 1; J <= I; J++)
			{
				W[I][J] = T[I][J] - W[I][J];
				W[J][I] = W[I][J];
				T[J][I] = T[I][J];
			}
		}
		D1 = Q[1];
		for (H = 1; H <= G; H++)
		{
			if (D1 == 0)
			{
				D = Ng[H] / N; //用样本频率代替先验概率
			}
			else
			{
				if (D1 == 1) //先验概率相等
				{
					D = 1 / G;
				}
				else
				{
					D = Q[H];
				}
			}
			LnQ[H] = Math.log(D) / Math.log(2.718282);
		}
		//U记逐步计算中之Wilks量，U = |W| / |T|
		//X记录选出的量，X(i) = 1 表示 Xi 已选中
		
		L = 0;
		Step = 0;
		eps = 0.000001;
		U = 1;
		for (I = 1; I <= M; I++)
		{
			X[I] = 0;
		}
		
		
		
		
		
		for (int l = -1;l<0; l--) {
			
			Step = Step + 1;
			
			Umax = eps;
			Umin = 1000;
			for (I = 1; I <= M; I++)
			{
				if (X[I] == 0)
				{
					if (T[I][I] >= eps)
					{
						Ui = W[I][I]/ T[I][I];
						if (Ui < eps)
						{
							Ui = eps;
							if (W[I][I] == 0)
							{
								
								return;//弹出
							}
						}
					}
					if (Ui < Umin)
					{
						Umin = Ui; //从未选量中找出 Umin
						Imin = I;
					}
				}
				else
				{
					Ui = T[I][I] / W[I][I]; //计算各变量的离差比 Ui
					if (Ui > Umax)
					{
						Umax = Ui; //从已选量中找出 Umax
						Imax = I;
					}
				}
			}
			//开始检验
			F12 = (double)((1 - Umax) * (N - L - G + 1) / (Umax * (G - 1)));
			if (F12 < F2)
			{
				L = L - 1;
				R = Imax;
				R12 = - R;
				X[R] = 0;
			}
			else
			{
				F12 = (double)((1 - Umin) * (N - L - G) / (Umin * (G - 1)));
				if (F12 <= (F1 + eps))
				{
					break;
				}
				else
				{
					L = L + 1;
					R = Imin;
					R12 = R;
					X[R] = 1;
				}
			}
			U = (double)((W[R][R] / T[R][R]) * U); //逐步计算 U = |W| / |T|
			//X2是U的近似值
			X2 = (double)(- (N - 1 - (L + G) / 2) * Math.log(U) / Math.log(2.718282));
			D = (double)(1 / T[R][R]);
			T[R][R] = 1;
			D1 = (double)(1 / W[R][R]);
			W[R][R] = 1;
			for (J = 1; J <= M; J++)
			{
				T[R][J] = T[R][J] * D;
				W[R][J] = W[R][J] * D1;
			}
			for (I = 1; I <= M; I++)
			{
				if (I != R)
				{
					D = (double)(T[I][R]);
					T[I][R] = 0;
					D1 = (double)(W[I][R]);
					W[I][R] = 0;
					for (J = 1; J <= M; J++)
					{
						T[I][J] = T[I][J] - D * T[R][J];
						W[I][J] = W[I][J] - D1 * W[R][J];
					}
				}
			}
			CalCoeD2(N, L, X, W, Mx, C, D2gh, Ng, Fhg);
			Cla(XY, X, C, LnQ, Pr, Dm, New_Sort);
		}
		
		if (L == 0)
		{
			return;
		}
		CalCoeD2(N, L, X, W, Mx, C, D2gh, Ng, Fhg);
		Cla(XY, X, C, LnQ, Pr, Dm, New_Sort);
		
		

		
		//保存New_Sort
		Save_command.setNew_Sort(New_Sort);
		//显示数据
		commandData.setNew_Sort(New_Sort);
		commandData.setCount(N);
		
	}
}
		
