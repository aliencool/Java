package com.cai.oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * aug 13 2014
 * I learned how to connect of oracle and manipulate the procedure of oracle;
 * */
public class ConnectOracle {
	public static void main(String []agrs) throws Exception
	{
		// 1: connect
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2:manipulate
		Connection _Connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:myoracle","scott","aa123");
		// 3:command
//		Statement _Statement = _Connection.createStatement();
//		
//		ResultSet _Set = _Statement.executeQuery("select * from emp");
//		
//		while(_Set.next())
//		{
//			System.out.println(_Set.getString(1));
//		}
		
		
		CallableStatement _Call = _Connection.prepareCall("{call test_cursor(?,?,?)}"); 
		
		// 4:register
		_Call.setInt(1, 2);
		_Call.registerOutParameter(2, oracle.jdbc.OracleTypes.NUMBER);
		_Call.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
		
		
		// 5:execute
		_Call.execute();
		
		// 6:get
		int _PageSize = _Call.getInt(2);
		
		System.out.println("Size:"+_PageSize);
		
		ResultSet _Set = (ResultSet)_Call.getObject(3);
		
		while(_Set.next())
		{
			System.out.println("Ename:"+_Set.getString(1));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
