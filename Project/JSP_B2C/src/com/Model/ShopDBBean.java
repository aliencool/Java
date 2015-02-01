package com.Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import com.Bean.NavigationBean;
import com.Bean.ShopBean;
import com.Bean.ShopMessageBean;
import com.localhost.Interface.Shop_db;
import com.localhost.connection.DataConnection;
public class ShopDBBean extends Shop_db{
	private ShopBean shopBean=null;
	public static int Total_Page=0;
	private Vector<ShopBean> ve=null;
	private Collection<ShopMessageBean> collection=null;
	private Vector<NavigationBean> navigation=null;
	public ShopDBBean()
	{
			dataConnection=new DataConnection();
			ve=new Vector<ShopBean>();
			//��ȡ����
			navigation=new Vector<NavigationBean>();
			collection=new Vector<ShopMessageBean>();
	}
	
	/*ִ���� */
	/*1:�����ύID������Ʒ */
	 public ShopBean SelectId(int id)
	 {
		String searchId="select * from shoplistinfo where shop_id=?";
		
		connection=dataConnection.getConnection();
		try {
			preparedStatement=connection.prepareStatement(searchId);
			preparedStatement.setInt(1, id);
			
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				shopBean=new ShopBean(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),resultSet.getInt(4),resultSet.getString(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CloseResultSet(resultSet);
			ClosePreparedStatement(preparedStatement);
			
		}
		return shopBean;
	 }
	/*1.1:���ݹؼ���������*/
	 public Vector<ShopBean> SelectKey(String key,int page)
	 {
		String searchKey="select * from shoplistinfo where shop_name like '%"+key+"%'";
		Statement statement=null;
		//����װ֮ǰ ���
		ve.clear();
		connection=dataConnection.getConnection();
		try {
			statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet=statement.executeQuery(searchKey);
			//�������
			resultSet.last();
			//ÿҳ��ʾ��ֵ
			int count_page=5;
			//�õ�����ҳ
			Total_Page=(resultSet.getRow()+count_page-1)/count_page;
			//����ָ��ҳ��
			resultSet.absolute((page-1)*count_page+1);
			//ÿҳ��ʾ
			int i=0;
			
			while(i<count_page&&!resultSet.isAfterLast())
			{
				shopBean=new ShopBean(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),resultSet.getInt(4),resultSet.getString(5));
				ve.add(shopBean);
				resultSet.next();
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CloseResultSet(resultSet);
			CloseStatement(statement);
			ClosePreparedStatement(preparedStatement);
			
		}
		return ve;
	 }
	/*2:�����ύID���жϹ���������Ƿ�������ݿ�����*/
	public boolean isEnogh(int id,int quantiy)
	{
		String searchCount="select shop_amount from shoplistinfo where shop_id=?";
		connection=dataConnection.getConnection();
		
		try {
			preparedStatement=connection.prepareStatement(searchCount);
			preparedStatement.setInt(1, id);
			
			resultSet=preparedStatement.executeQuery();
			//�ж��Ƿ����
			if(resultSet.next())
			{
				int Quantity=resultSet.getInt(1);
				if(Quantity>=quantiy)
				{
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CloseResultSet(resultSet);
			ClosePreparedStatement(preparedStatement);
			
		}
		return false;
	}
	
	//��ȡÿҳ������
	public Collection<ShopBean> shopBeans(int page)
	{
		ArrayList<ShopBean> shopBeans=new ArrayList<ShopBean>();
		String Msg_All="select * from shoplistinfo order by shop_name";
		connection=dataConnection.getConnection();
		try {
			Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet=statement.executeQuery(Msg_All);
			
			//�������
			resultSet.last();
			
			//�õ�����
			int All_count=resultSet.getRow();
			
			//����ҳ��
			int page_count=3;
			
			//�õ��ܹ�ҳ��
			Total_Page=(All_count+page_count-1)/page_count;
			
			//�ƶ�����ǰҳ��
			//��1��Ϊ�˲�������һ������
			resultSet.absolute((page-1)*page_count+1);
			
			//����
			int i=0;
			while(i<page_count&&!resultSet.isAfterLast())
			{
				shopBean=new ShopBean(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4),resultSet.getString(5));
				shopBeans.add(shopBean);
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
	
	//3.1:����
	public boolean insert_shopmessage(int shop_id,int id,int level,String mesg,String time)
	{
		
		String sql_insert="insert into shop_message(shop_id,uid,level,message,time_date) values"+"("+shop_id+","+id+","+level+","+"'"+mesg+"'"+","+"'"+time+"'"+")";
		System.out.println(sql_insert);
		connection=dataConnection.getConnection();
		
		try {
			statement=connection.createStatement();
			//ִ�в������
			if(statement.executeUpdate(sql_insert)!=0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CloseStatement(statement);
		}
		
		
		
		return false;
	}
	
	/*
	 *3.2: @param id:�ǲ�ѯҳ�������
	 * */
	public Collection<ShopMessageBean> selec_shopmessage(int id)
	{
		String select="select user_n,level,message,time_date from register ,shop_message where register.id=shop_message.uid and shop_message.shop_id=?";
		ShopMessageBean messageBean=null;
		connection=dataConnection.getConnection();
		//ÿ���������һ��
		collection.clear();
		
		try {
			preparedStatement=connection.prepareStatement(select);
			preparedStatement.setInt(1, id);
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				messageBean=new ShopMessageBean(resultSet.getString(1), resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4));
				collection.add(messageBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			ClosePreparedStatement(preparedStatement);
		}
		return collection;
	}

	
	
	//4:����
	public Collection<NavigationBean> getNavigation()
	{
		
		//��ȡ��ѯ�ַ���
		String selct="select category_name,group_concat(category_son_name) from category as ca left join category_son as cs on ca.category_id=cs.category_id group by ca.category_id";
		//���幹��������
		connection=dataConnection.getConnection();
		//ִ�в�ѯ
		try {
			statement=connection.createStatement();
			
			ResultSet resultSet=statement.executeQuery(selct);
			
			while(resultSet.next())
			{
				navigation.add(new NavigationBean(resultSet.getString(1),resultSet.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return navigation;
		
	}
	//4.1:�����ܵ�����ѯ���ݿ�
	public Collection<ShopBean> getTotalNavigation(String key,int page)
	{
		//����
		ArrayList<ShopBean> shopBeans=new ArrayList<ShopBean>();
		//��ȡ��ѯ�ַ���
		String select="select * from shoplistinfo where shop_category in (select category_id from category_son " +
				"where category_id=(select category_id from category where category_name='"+key+"'))";
		System.out.println(select);
		//���幹��������
		connection=dataConnection.getConnection();
		//ִ�в�ѯ
		try {
			statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet=statement.executeQuery(select);
			
			//�������
			resultSet.last();
			
			//�õ�����
			int All_count=resultSet.getRow();
			
			//����ҳ��
			int page_count=3;
			
			//�õ��ܹ�ҳ��
			Total_Page=(All_count+page_count-1)/page_count;
			
			//�ƶ�����ǰҳ��
			//��1��Ϊ�˲�������һ������
			resultSet.absolute((page-1)*page_count+1);
			
			//����
			int i=0;
			while(i<page_count&&!resultSet.isAfterLast())
			{
				shopBean=new ShopBean(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4),resultSet.getString(5));
				shopBeans.add(shopBean);
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
	
	//4.2:�õ��ӵ���
	public Collection<NavigationBean> getSonNavigation(String key)
	{
		//����
		ArrayList<NavigationBean> navigationBean=new ArrayList<NavigationBean>();
		//��ȡ��ѯ�ַ���
		String select="select category_son_name from category_son where category_id=( select category_idfrom category where " +
				"category_name='"+key+"')";

		//���幹��������
		connection=dataConnection.getConnection();
		//ִ�в�ѯ
		try {
			statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet=statement.executeQuery(select);
			
			while(resultSet.next())
			{
				
				navigation.add(new NavigationBean(resultSet.getString(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return navigationBean;
		
	}
	//4.3�����ӵ�����������
	public Collection<ShopBean> getSon_TotalNavigation(String key_father,String key,int page)
	{
		//����
		ArrayList<ShopBean> shopBeans=new ArrayList<ShopBean>();
		//��ȡ��ѯ�ַ���
		String select="select * from shoplistinfo where  " +
				"shop_son_category=(select  category_son_id from  category_son where category_son_name='"+key+"') and shop_category=" +
						"(select  category_id from  category where category_name='"+key_father+"')";
		System.out.println(select);
		//���幹��������
		connection=dataConnection.getConnection();
		//ִ�в�ѯ
		try {
			statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet=statement.executeQuery(select);
			
			//�������
			resultSet.last();
			
			//�õ�����
			int All_count=resultSet.getRow();
			
			//����ҳ��
			int page_count=3;
			
			//�õ��ܹ�ҳ��
			Total_Page=(All_count+page_count-1)/page_count;
			
			//�ƶ�����ǰҳ��
			//��1��Ϊ�˲�������һ������
			resultSet.absolute((page-1)*page_count+1);
			
			//����
			int i=0;
			while(i<page_count&&!resultSet.isAfterLast())
			{
				shopBean=new ShopBean(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4),resultSet.getString(5));
				shopBeans.add(shopBean);
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
	
	//5ͼ���ҵ����ֵȼ�
	public ResultSet search_level(String category)
	{
		String select="";
		//ȫ���ĺ���
		if(category.equals("All"))
		{
			select="select shop_name,avg(level) from shoplistinfo,shop_message where"+" shoplistinfo.shop_id=shop_message.shop_id group by shop_name";
		}
		else
		{
			//�õ������
			select="select shop_name,avg(level)  from shoplistinfo,shop_message where "+
			"shoplistinfo.shop_id=shop_message.shop_id"+
			" and shoplistinfo.shop_category in" +
			"(select category_id from category where category_name='"+category+"') "+"group by shop_name";
		
			
		}

		try {
			statement=dataConnection.getConnection().createStatement();
			resultSet=statement.executeQuery(select);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
}
