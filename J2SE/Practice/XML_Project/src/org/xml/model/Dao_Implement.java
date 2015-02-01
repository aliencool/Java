package org.xml.model;

import org.xml.bean.Data_Bean;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class  Dao_Implement implements Dao_Interface{
	private Map<String,String> column_name=null;
	
	public Data_Bean getColumn_Name(String T_name) {
		//开创保存
		Data_Bean db=new Data_Bean();
		column_name=new HashMap<String, String>();
		//使用Data来设置
		try {
			DatabaseMetaData databaseMetaData=Dao_Connection.get_Mysql().getMetaData();
			
			//把表名装进装进resultset
			ResultSet resultSet=databaseMetaData.getColumns(Dao_Connection.get_Mysql().getCatalog(), null, T_name,"%");
			
			
			while(resultSet.next())
			{
				//解决方案:把列名放进set集合 遍历 值就resultset 来放
				get_Value(resultSet.getString("COLUMN_NAME"),T_name);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.setColumn_name(column_name);
		
		return db;
	}

	private void get_Value(String column_n,String T_name) {
		// TODO Auto-generated method stub
		String select="select " + column_n+" " +"from "+T_name;
		//创建命令行获取值
		try {
			PreparedStatement preparedStatement=Dao_Connection.get_Mysql().prepareStatement(select);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				//放进表名与值  （在做复杂化的时候 可以放进一个list集合）
				column_name.put(column_n, resultSet.getString(1));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Data_Bean getData_Name() {
		
		//开创属性
		Data_Bean db=new Data_Bean();
		//保存表
		String [] data_name=null;
		//记录器
		int i=0;
		//使用Data来设置
		try {
			DatabaseMetaData databaseMetaData=Dao_Connection.get_Mysql().getMetaData();
			//把表名装进装进resultset
			ResultSet resultSet=databaseMetaData.getTables(null, null, null, new String[]{"Table"});
			
			data_name=new String[20];
			while(resultSet.next())
			{
				data_name[i]=resultSet.getString(3);
				i++;
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.setData_name(data_name);
		
		return db;
	}

	public void Insert(String []values)  {
		String sql="insert into dingdan values(?,?,?)";
		
		try {
			PreparedStatement preparedStatement=Dao_Connection.get_Mysql().prepareStatement(sql);
			preparedStatement.setString(1, values[0]);
			preparedStatement.setString(2, values[1]);
			preparedStatement.setString(3, values[2]);
			
			if(preparedStatement.executeUpdate()>0)
			{
				System.out.println("插入成功");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
