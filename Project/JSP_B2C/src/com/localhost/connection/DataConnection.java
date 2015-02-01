/*2013年11月13日0:52:58
 * 数据库连接类
 * */
package com.localhost.connection;
import java.sql.*;

public class DataConnection {
	private final String Connect="com.mysql.jdbc.Driver";
	private final String Connect_msg="jdbc:mysql://localhost:3306/myzh&characterEncoding=utf-8";
	private final String DateUser="root";
	private final String DatePass="123";
	private Connection connection=null;

	public DataConnection()
	{
		try {
			Class.forName(Connect);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myzh?user=root&password=123&characterEncoding=utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return connection;
	}
	public void close()
	{
		if(connection!=null)
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
