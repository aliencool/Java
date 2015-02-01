package org.grade.model_twice;

import java.util.HashMap;
import java.util.Map;

import org.grade.bean.Get_Excel_twice;
import org.grade.bean.Save_twice;
import org.grade.bean.Save_twice_data;

public class logic {
	//定义为全局:
	
	/**
	 * @param args
	 */
	private final static String st1="A组";
	private final static String st2="B组";
	private final static String st3="C组";
	

	
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
	
	public static Save_twice_data complute(Save_twice_data std)
	{
		//M:列(固定)
		int M=3;
		double Ya = 0;
		double Yb = 0;
		double Yc;
		//全部行
		int initRow=Get_Excel_twice.getA_row()+Get_Excel_twice.getB_row()+Get_Excel_twice.getC_row();
		//原
		 String []origin=new String[initRow+1];
		 String []now=new String[initRow+1];

		 
		int J;
		int I;
		int M1;
		int K;
		double S1=0;
		double S2;
		double FF;
		double F005 = 0;
		double F001 = 0;
		//A的样本数
		int N1=Get_Excel_twice.getA_row();
		//B的样本数
		int N2=Get_Excel_twice.getB_row();
		
		//C的样本数
		int N3=Get_Excel_twice.getC_row();
		
		double [] Y1 = new double [N1+1]; //保存样本判别值
		double [] Y2 = new double [N2+1];
		double [] Y3 = new double [N3+1];
		
		double []CP1=new double[M+1];
		double []CP2=new double[M+1];
		double [][]XS=new double[M+1][M+1];
		double  []DD=new double[M+1];
		double   []CC=new double[M+1];
		//得到A
		double [][]X1=Get_Excel_twice.getX1();
		
		//得到B
		double [][]X2=Get_Excel_twice.getX2();
		
		//得到C
		double [][]X3=Get_Excel_twice.getX3();
	
		
		//平均值
		for (J = 1; J <= M; J++)
		{
			S1 = 0;
			for (I = 1; I <= N1; I++)
			{
				
				S1 = S1 + X1[I][J];
			}
		
			CP1[J] = S1 / N1; //A组样本的变量平均值
			System.out.println(CP1[J]);
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
		std.setMh(D2);
		
		//F检验值
		FF = D2 * (N1 * N2 * (N1 + N2 - M - 1)) / ((N1 + N2) * ((N1 + N2) - 2) * M);
		System.out.println("F校验值:"+FF);
		int UA = M;
		int Ue = N1 + N2 - M - 1;
		Logic_Pf_Dist.PF_DIST_F005(UA, Ue, 0.05, F005); //计算显著性为0.05的F临界值
		Logic_Pf_Dist.PF_DIST_F001 (UA, Ue, 0.01, F001); //计算显著性为0.01的F临界值
		std.setFone(Logic_Pf_Dist.getF001());
		std.setFive(Logic_Pf_Dist.getF005());
		if (FF <= Logic_Pf_Dist.getF005())
		{
			std.setMessage("判别方程的意义不显著");
		}
		if (FF > Logic_Pf_Dist.getF005() && FF <= Logic_Pf_Dist.getF001())
		{
			std.setMessage( "判别方程的意义显著");
		}
		if (FF > Logic_Pf_Dist.getF001())
		{
			std.setMessage( "判别方程的特别显著");
		}
		
	
		
		//综合指标
		for(I=1;I<=M;I++)
		{
			Ya=Ya+CP1[I]*CC[I];
			
			Yb=Yb+CP2[I]*CC[I];
			
			
		}
		 Yc = (N1 * Ya + N2 * Yb) / (N1 + N2) ;
		 
	
		
		
		//根据判别方程计算每个样本的判别值
		for (I = 1; I <= N1; I++)
		{
			Y1[I] = 0;
			for (J = 1; J <= M; J++)
			{
				//Y1为A组样本的判别值
				Y1[I] = Y1[I] + X1[I][J] * CC[J];
			}
			
			
		}
		for (I = 1; I <= N2; I++)
		{
			Y2[I] = 0;
			for (J = 1; J <= M; J++)
			{
				//Y2为B组样本的判别值
				Y2[I] = Y2[I] + X2[I][J] * CC[J];
			}
		
		}
		
		for (I = 1; I <= N3; I++)
		{
			Y3[I] = 0;
			for (J = 1; J <= M; J++)
			{
				//Y3为C组样本的判别值
				Y3[I] = Y3[I] + X3[I][J] * CC[J];
			}
		}
		
		
		
		 for (I = 1; I <= N1; I++) {
				
				if (Y1[I] > Yc)
					now[I] = st1;
				else
					now[I] = st2;
				origin[I] = st1;
				
				
			}
			//显示B组判别结果
			for (I = N1 + 1; I <= N1 + N2; I++) {
				
				if (Y2[I - N1] > Yc)
					now[I] = st1;
				else
					now[I] = st2;
				origin[I] = st2;
			}
			//显示待定组判别结果
			for (I = N1 + N2 + 1; I <= initRow; I++) {

				if (Y3[I - N1 - N2] > Yc)
					now[I] = st1;
				else
					now[I] = st2;
				origin[I]= st3;
			}
		 
		
		
		//Y1 A
		Save_twice.setY1(Y1);
		//Y2 B
		Save_twice.setY2(Y2);
		//Y3 C
		Save_twice.setY3(Y3);
		//FF的值
		std.setFF(FF);
		//分类值
		Map<Integer, String> map=new HashMap<Integer, String>();
		
		for (int l = 1; l <=initRow; l++) {
			map.put(l,now[l]);
			map.put(l+888, origin[l]);
		}
		std.setOrigin(map);
		
		return std;
	}
	
	
	}
