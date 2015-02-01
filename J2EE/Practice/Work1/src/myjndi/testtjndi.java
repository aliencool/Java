package myjndi;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;
import java.util.Hashtable;

public class testtjndi {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		 DataSource ds=null;
		 Connection myConn=null;
		 Statement mystatement=null;
		 ResultSet myset=null;
		 SingleTest st=SingleTest.getInstanceof();
		 ds=(DataSource)st.lookup("Myfirst");
		 
		   if(ds==null)
			   System.out.println("error");
		   else
		       System.out.println("Connection ok");
		   
	
		
		try{
		  myConn=ds.getConnection();
		  mystatement=myConn.createStatement();
		  myset=mystatement.executeQuery("select * from StudentTest");
		  while(myset.next()){
			  System.out.println(myset.getString("Student")+myset.getString("Studentid"));
		  }
		}catch(Exception e){e.printStackTrace();}
	 }

	}

