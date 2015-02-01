package org.xml.model;

import org.xml.bean.Data_Bean;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class  Dao_Implement implements Dao_Interface{
	private Map<String,String> column_name=null;
	
	public Data_Bean getColumn_Name(String T_name) {
		//��������
		Data_Bean db=new Data_Bean();
		column_name=new HashMap<String, String>();
		//ʹ��Data������
		try {
			DatabaseMetaData databaseMetaData=Dao_Connection.get_Mysql().getMetaData();
			
			//�ѱ���װ��װ��resultset
			ResultSet resultSet=databaseMetaData.getColumns(Dao_Connection.get_Mysql().getCatalog(), null, T_name,"%");
			
			
			while(resultSet.next())
			{
				//�������:�������Ž�set���� ���� ֵ��resultset ����
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
		//���������л�ȡֵ
		try {
			PreparedStatement preparedStatement=Dao_Connection.get_Mysql().prepareStatement(select);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				//�Ž�������ֵ  ���������ӻ���ʱ�� ���ԷŽ�һ��list���ϣ�
				column_name.put(column_n, resultSet.getString(1));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Data_Bean getData_Name() {
		
		//��������
		Data_Bean db=new Data_Bean();
		//�����
		String [] data_name=null;
		//��¼��
		int i=0;
		//ʹ��Data������
		try {
			DatabaseMetaData databaseMetaData=Dao_Connection.get_Mysql().getMetaData();
			//�ѱ���װ��װ��resultset
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
				System.out.println("����ɹ�");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
