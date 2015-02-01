package tran;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Demo1 {

	/**
	 * @param args
	 */
	static int i=0;
	static boolean flag=true;
	
	static void propery(String S_msg,int I_i,boolean flag)
	{
		Properties properties =new Properties();
		InputStream inStream;
		OutputStream outputStream;
		File f=new File("name-action.txt");
		
		if(!f.exists())
		{
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		try {
			inStream = new FileInputStream(f);
			properties.load(inStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(properties.get(S_msg)==null)
		{
			properties.setProperty(S_msg, String.valueOf(I_i));
			try {
				outputStream=new FileOutputStream(f);
				properties.store(outputStream, "信息");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(flag)
		{
			System.out.println(S_msg+"条"+"运行"+properties.getProperty(S_msg)+"次");
		}
	
		
	}
	
	
	static  int  gsd (int X, int Y)
    {      int Q=X;
    		propery("第1条",i++,flag);
           int R=Y;
           propery("第2条",i++,flag);
           while(Q!=R)
               {    
        	   propery("第3条",i++,flag);
        	   	if(Q>R)
        	   	{
        	   		propery("第4条",i++,flag);
        	   		Q=Q-R;
        	   	}
                    else 
                {
                    	propery("第5条",i++,flag);
                    	R=R-Q;
                }
               }
           System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"开始");
               return Q;
  }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"开始");
		 flag=true;
		 
		int i_max=gsd(98,63);
		System.out.println("最大公约数为"+i_max);
	}

}
