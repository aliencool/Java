package org.grade.model_twice;

public class Logic_lnGamma {
	
	private static double GA1 = 0;
	private static double GA2 = 0;
	private static double GA3 = 0;
	
	
	




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


	/*«ÛGA1*/
	public static void lnGamma_GA1(double X, double G) {
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
	    { a = a * (Y - I);}
	     // I
	    G = G - Math.log(a);
	    setGA1(G);
	}
	
	
	/*«ÛGA2*/
	public static void lnGamma_GA2(double X, double G) {
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
	    setGA2(G);
	}
	
	/*«ÛGA3*/
	public static void lnGamma_GA3(double X, double G) {
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
	    setGA3(G);
	}
	

}
