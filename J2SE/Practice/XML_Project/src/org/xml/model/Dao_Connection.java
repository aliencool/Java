package org.xml.model;

import java.sql.DriverManager;

import java.sql.Connection;

public class Dao_Connection {
	//�����಻�ܴ�������
	//ʹ�õ�sql����ȡ����
	private Dao_Connection(){}
	
	public static Connection get_Mysql()
	{
		Connection connection=null;
		//�����ڴ�
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
