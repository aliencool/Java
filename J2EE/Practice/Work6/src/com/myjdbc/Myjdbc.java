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
				vc.add(new StuBean(rs.getInt("sno"),//第一次设置进行匹配 添加对象
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
		
		//执行 命令 设置 第一个值为id
		pstmt(select_All).setInt(1, id);
		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			st=new StuBean(rs.getInt("sno"),rs.getString("sname"),rs.getInt("chinese"),rs.getInt("math"));//第一次设置进行匹配
		}
		pstmt.close();
		rs.close();
		return st;
		
	}
	
	public void updateDb(int math_update) throws Exception
	{
		String select_All="update stdb set math=? where sno=?";
		
		//执行 命令 设置 第一个值为id
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123");
		pstmt=con.prepareStatement(select_All);
		pstmt.setInt(1, math_update);
		pstmt.setInt(2, id);//指定更改的表
		
		
		int row=pstmt.executeUpdate();
		if(row>0)
		{
			System.out.println("修改完成");
		}
		else if(row<0)
		{
			System.out.println("修改失败");
		}
		else
		{
			System.out.println("同样的值");
		}
		pstmt.close();
		
	}
	
	
	
	
}
