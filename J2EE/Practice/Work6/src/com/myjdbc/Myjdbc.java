package com.myjdbc;
import java.util.*;
import java.sql.*;

import com.BindBean.StuBean;

public class Myjdbc {
	private int id;
	private Vector<StuBean> vc;
	private PreparedStatement pstmt=null;
	private StuBean st=null;
	public Myjdbc()
	{
		vc=new Vector<StuBean>();
	}
	public Myjdbc(int id)
	{
		this.id=id;
		vc=new Vector<StuBean>();
	}
	
	public PreparedStatement pstmt(String select_All)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123");
			pstmt=con.prepareStatement(select_All);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	
	}
	
	
	public Vector<StuBean> select() throws SQLException
	{
		String select_All="select * from stdb";
		ResultSet rs=null;
		try {
			rs=pstmt(select_All).executeQuery();
			while(rs.next())
			{
				vc.add(new StuBean(rs.getInt("sno"),//��һ�����ý���ƥ�� ��Ӷ���
				rs.getString("sname"),
				rs.getInt("chinese"),
				rs.getInt("math")));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs.close();
		
		return vc;
	}
	
	
	public StuBean selectById() throws Exception
	{
		String select_All="select * from stdb where  sno=? ";
		
		//ִ�� ���� ���� ��һ��ֵΪid
		pstmt(select_All).setInt(1, id);
		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			st=new StuBean(rs.getInt("sno"),rs.getString("sname"),rs.getInt("chinese"),rs.getInt("math"));//��һ�����ý���ƥ��
		}
		pstmt.close();
		rs.close();
		return st;
		
	}
	
	public void updateDb(int math_update) throws Exception
	{
		String select_All="update stdb set math=? where sno=?";
		
		//ִ�� ���� ���� ��һ��ֵΪid
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123");
		pstmt=con.prepareStatement(select_All);
		pstmt.setInt(1, math_update);
		pstmt.setInt(2, id);//ָ�����ĵı�
		
		
		int row=pstmt.executeUpdate();
		if(row>0)
		{
			System.out.println("�޸����");
		}
		else if(row<0)
		{
			System.out.println("�޸�ʧ��");
		}
		else
		{
			System.out.println("ͬ����ֵ");
		}
		pstmt.close();
		
	}
	
	
	
	
}
