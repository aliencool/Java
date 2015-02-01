package com.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.Bean.DAOBean;
import com.Bean.ShopBean;
import com.localhost.Interface.Shop_db;
import com.localhost.connection.DataConnection;

public class Shop_adminDBBean extends Shop_db {
	public  static int Total_Page=0;//��ҳ��
	/*1:ҳ������Ʒ*/
	public Shop_adminDBBean()
	{
			dataConnection=new DataConnection();
	}
	//��ȡÿҳ������
	public Collection<ShopBean> shopBeans(int page)
	{
		ArrayList<ShopBean> shopBeans=new ArrayList<ShopBean>();
		String Msg_All="select shop_id,shop_name,shop_amount,shop_price,shop_category,shop_son_category from shoplistinfo order by shop_name";
		connection=dataConnection.getConnection();
		try {
			Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet=statement.executeQuery(Msg_All);
			
			//�������
			resultSet.last();
			
			//�õ�����
			int All_count=resultSet.getRow();
			
			//����ҳ��
			int page_count=5;
			
			//�õ��ܹ�ҳ��
			Total_Page=(All_count+page_count-1)/page_count;
			
			//�ƶ�����ǰҳ��
			//��1��Ϊ�˲�������һ������
			resultSet.absolute((page-1)*page_count+1);
			
			//����
			int i=0;
			while(i<page_count&&!resultSet.isAfterLast())
			{
				shopBeans.add(new ShopBean(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6)));
				i++;
				//�õ���һ��
				resultSet.next();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shopBeans;
		
	}
	
	/*2:�õ�ȫ�����û�*/
	public Collection<DAOBean> UserBeans(int page)
	{
		ArrayList<DAOBean> daoBeans=new ArrayList<DAOBean>();
		String Msg_All="select id,user_n,email,ip,add_time from register order by user_n";
		connection=dataConnection.getConnection();
		try {
			Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet=statement.executeQuery(Msg_All);
			
			//�������
			resultSet.last();
			
			//�õ�����
			int All_count=resultSet.getRow();
			
			//����ҳ��
			int page_count=5;
			
			//�õ��ܹ�ҳ��
			Total_Page=(All_count+page_count-1)/page_count;
			
			//�ƶ�����ǰҳ��
			//��1��Ϊ�˲�������һ������
			resultSet.absolute((page-1)*page_count+1);
			
			//����
			int i=0;
			while(i<page_count&&!resultSet.isAfterLast())
			{
				daoBeans.add(new DAOBean(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
				i++;
				//�õ���һ��
				resultSet.next();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoBeans;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
