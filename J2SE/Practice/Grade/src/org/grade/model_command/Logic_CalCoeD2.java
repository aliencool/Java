package org.grade.model_command;

import org.grade.bean.Get_Excel_command;
import org.grade.bean.Save_command;
import org.grade.bean.Save_command_data;

public class Logic_CalCoeD2 {
	//���б�����ı���������
	//�о����� �о����� G������
	
	private static int intRow=Get_Excel_command.getIntRow()-1;
	private static int intCol=Get_Excel_command.getIntCol()-1;//������
	private static int N = intRow;//��������
	private static int M = intCol - 1;
	private static int G=3; //������
	private static int L; //����ѡ�еı�������
	private static double[] Q=new double[G+1]; //�������
	private static double[][] XY; //�۲�����
	private static double[][] Mx=new double[G+2][M+1]; //ƽ��ֵ
	private static double[] Ng=new double[G+1]; //���ַ����������
	private static double[][] C=new double[G+1][M+1]; //�б�ϵ��
	private static double[] D2gh=new double[(G-1)*G/2+1]; //�����ŵ��˹����
	private static double[] Fhg=new double[(G-1)*G/2+1]; //F����ֵ
	private static double[][] Dm=new double[G+2][G+2]; //�б����
	private static double[][] W=new double[M+1][M+1]; //����������
	private static double[][] T=new double[M+1][M+1]; //��������
	private static double[] X=new double[M+1]; //��¼�����Ƿ�ѡ��
	private static double[] LnQ=new double[G+1]; //�����б������м���
	private static double[] Pr=new double[G+1]; //������������ʵ��м���
	private static double[][] New_Sort=new double[N+2][5]; //�·���ͺ������
	
	
	

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
		M = X.length - 1; //G�Ƿ�������M�Ǳ�����
		for (H = 1; H <= G; H++)
		{
			C0 = 0;
			for (I = 1; I <= M; I++)
			{
				Ci = 0;
				//X(i) = 0 ��ʾΪδѡ����������ѡ
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
					
					D2hg[D] = D2; //�����ŵ��˹����
					Fhg[D] = D2 * ((N - G - L + 1) * Ng[H] * Ng[K] / (L * (N - G) * (Ng[H] + Ng[K]))); //F����ֵ
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
				Pr[H] = Yh; //�б���
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
			Ymax = (double)Pr[(int)Hmax] / D; //�������
			H = (int) XY[K][M1]; //ԭ������
			Dm[(int)Hmax][H] = Dm[(int)Hmax][H] + 1; //�γ��б����
			// "ԭ������" = H, "�·���" = Hmax, "�������" = Ymax
			
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
		
		//��ͨ����:
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
		
		
		//��������
		XY = Get_Excel_command.getXY(); 
	
		
		
		//������ʾ������
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
				System.out.println("ԭ������޸ĺ�����");
				return;
			}
			Ng[H] = Ng[H] + 1; //NgΪ���ַ����������
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
				Mx[H][I] = Mx[H][I] / Ng[H]; //ƽ��ֵ
			}
			Mx[G1][I] = D / N; //��ƽ��ֵ
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
					T[I][J] = D * X[J] + T[I][J]; //��������
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
					W[I][J] = D1 * X[J] + W[I][J]; //������ B�������� W ��������
				}
			}
		}
		//�������������� W = T - B������ W��T ���ɷ���
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
				D = Ng[H] / N; //������Ƶ�ʴ����������
			}
			else
			{
				if (D1 == 1) //����������
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
		//U���𲽼�����֮Wilks����U = |W| / |T|
		//X��¼ѡ��������X(i) = 1 ��ʾ Xi ��ѡ��
		
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
								
								return;//����
							}
						}
					}
					if (Ui < Umin)
					{
						Umin = Ui; //��δѡ�����ҳ� Umin
						Imin = I;
					}
				}
				else
				{
					Ui = T[I][I] / W[I][I]; //��������������� Ui
					if (Ui > Umax)
					{
						Umax = Ui; //����ѡ�����ҳ� Umax
						Imax = I;
					}
				}
			}
			//��ʼ����
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
			U = (double)((W[R][R] / T[R][R]) * U); //�𲽼��� U = |W| / |T|
			//X2��U�Ľ���ֵ
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
		
		

		
		//����New_Sort
		Save_command.setNew_Sort(New_Sort);
		//��ʾ����
		commandData.setNew_Sort(New_Sort);
		commandData.setCount(N);
		
	}
}
		
