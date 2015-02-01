package org.xml.model;

import java.sql.DriverManager;

import java.sql.Connection;

public class Dao_Connection {
	//连接类不能创建对象
	//使用的sql来获取连接
	private Dao_Connection(){}
	
	public static Connection get_Mysql()
	{
		Connection connection=null;
		//加载内存
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql:///myzh", "root", "123");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return connection;
	}
	
}
