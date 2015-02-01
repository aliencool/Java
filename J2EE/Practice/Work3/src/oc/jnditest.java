package oc;
import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.transform.Result;
class jnditest
{
	Connection conn = null;
	java.sql.PreparedStatement pstmt = null;
	ResultSet rs = null;
	String select_msg="select * from studenttest where id=?";
	String select_use="select * from pass where user=? and password=?";
	public ArrayList<String> ay=null;
	public jnditest() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void search_msg(int x)
	{
	
		
		try {

			//执行
			pstmt= conn.prepareStatement(select_msg);
			pstmt.setInt(1, x);
			
			//获取查找结果
			ResultSet rs=pstmt.executeQuery();
			ay=new ArrayList<String>();
			while(rs.next())
			{
				ay.add(rs.getString("name"));
				ay.add(rs.getString("sex"));
				ay.add(String.valueOf(rs.getInt("score")));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean search_use(String use,String password)
	{
	
		
		try {
			//执行
			pstmt= conn.prepareStatement(select_use);
			pstmt.setString(1, use);
			pstmt.setString(2, password);
			ResultSet res=pstmt.executeQuery();
			if(res.next())
			{
				System.out.println(11);
				return true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}