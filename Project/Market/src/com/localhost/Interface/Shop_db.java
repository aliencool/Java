package com.localhost.Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Model.DataImplc;
import com.localhost.connection.DataConnection;

public abstract class Shop_db {
	protected DataImplc dataImplc=null;
	protected Connection connection=null;
	protected DataConnection dataConnection=null;
	protected PreparedStatement preparedStatement=null;
	protected Statement statement=null;
	protected ResultSet resultSet=null;
	/*πÿ±’¿‡
	 * */
	protected void CloseConnection(Connection connection)
	{
		if(connection!=null)
		{
			try {
				connection.close();
				connection=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	protected void ClosePreparedStatement(PreparedStatement preparedStatement)
	{
		if(preparedStatement!=null)
		{
			try {
				preparedStatement.close();
				preparedStatement=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	protected void CloseResultSet(ResultSet resultSet)
	{
		if(resultSet!=null)
		{
			try {
				resultSet.close();
				resultSet=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	protected void CloseStatement(Statement statement) {
			if(statement!=null)
			{
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}

	
}
