package org.grade.model_twice;

public class Logic_Pnorm {
	private static double Q;
	private static double YQ;
	public static double getQ() {
		return Q;
	}
	public static void setQ(double q) {
		Q = q;
	}
	public static double getYQ() {
		return YQ;
	}
	public static void setYQ(double yQ) {
		YQ = yQ;
	}
	
	
	public static void Pnorm(double Q,double X)
	{
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
	   
	    setYQ(X);
	 
	}
}
