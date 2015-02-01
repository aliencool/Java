package First;

import java.sql.*;

public class DbTest {
	private TestBean tb=null;
	private Connection  cc=null;
	private PreparedStatement ps=null;
	public DbTest(TestBean tb)
	{
		System.out.println(tb.getPassword()+tb.getName());
		this.tb=tb;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cc=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public boolean ok()
	{
		
	
	return	cheack(tb.getName(), tb.getPassword());
	}
	
	public boolean cheack(String ss,String pp)
	{
		try {	
			
			ps=cc.prepareStatement("select user,password from pass where user=? AND password=?");
			ps.setString(1, ss);
			ps.setString(2, pp);
			ResultSet resultSet=ps.executeQuery();
			if(!resultSet.next())
			{
				
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
}
