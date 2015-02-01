package com.Model;
import java.sql.*;

import com.Bean.DAOBean;
import com.localhost.Interface.IUserfunction;
import com.localhost.connection.DataConnection;

public class DataImplc implements IUserfunction{
	private DataConnection  dataconnection=null; 
	private PreparedStatement preparedStatement=null;
	private DAOBean bean=null;
	public DataImplc()
	{
		dataconnection=new DataConnection();
	}
	
	
	public boolean Cheack_user(DAOBean db) {
		String cheack_user_password="";
		
		if(db.getPassword()!=null)
		{
			cheack_user_password="select user_n,password from register where user_n=? and password=?";
		}
		else
		{	
			cheack_user_password="select user_n from register where user_n=?";
			
		}
		
		try {
			preparedStatement=dataconnection.getConnection().prepareStatement(cheack_user_password);
			if(db.getPassword()!=null)
			{
				preparedStatement.setString(1, db.getUser());
				preparedStatement.setString(2,db.getPassword());
			}
			else
			{
				//说明服务器验证的是用户名
				preparedStatement.setString(1, db.getUser());
			}
			ResultSet res=preparedStatement.executeQuery();
			if(res.next())
			{
				System.out.println(res.getString(1)+ db.getUser());
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(preparedStatement!=null)
			{
				try {
					preparedStatement.close();
					dataconnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	//更新
	public void update_re(String sql)
	{
		try {
			preparedStatement=dataconnection.getConnection().prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			//关闭
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//AllInfo
	public DAOBean Check_ALL(String user)
	{
		String cheack_user_id="select * from register where user_n=?";
		
		try {
			preparedStatement=dataconnection.getConnection().prepareStatement(cheack_user_id);
			preparedStatement.setString(1,user);
			ResultSet res=preparedStatement.executeQuery();
			if(res.next())
			{
				bean=new DAOBean(res.getString(2),res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(8), res.getString(7), "");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return bean;
	}
	
	
	
	
	/*check_id
	 * */
	public int Cheack_id(String user) {
		String cheack_user_id="select id from register where user_n=?";
		try {
			preparedStatement=dataconnection.getConnection().prepareStatement(cheack_user_id);
			preparedStatement.setString(1,user);
			ResultSet res=preparedStatement.executeQuery();
			if(res.next())
			{
				return res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(preparedStatement!=null)
			{
				try {
					preparedStatement.close();
					dataconnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
	
	
	public boolean Insert_user(DAOBean db) {
		String insert_user_password="Insert into register(user_n,password,address,email,phone,city,country,add_time,ip) values(?,?,?,?,?,?,?,?,?)";
		try {
			preparedStatement=dataconnection.getConnection().prepareStatement(insert_user_password);
			preparedStatement.setString(1, db.getUser());
			preparedStatement.setString(2, db.getPassword());
			preparedStatement.setString(3, db.getAddress());
			preparedStatement.setString(4, db.getemail());
			preparedStatement.setString(5, db.getPhone());
			preparedStatement.setString(6, db.getCity());
			preparedStatement.setString(7, db.getCountry());
			preparedStatement.setString(8, db.getTime());
			preparedStatement.setString(9, db.getIp());
			//判断是否为0
			if(preparedStatement.executeUpdate()!=0)
			{
				System.out.println("插入成功");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(preparedStatement!=null)
			{
				try {
					preparedStatement.close();
					dataconnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

}
