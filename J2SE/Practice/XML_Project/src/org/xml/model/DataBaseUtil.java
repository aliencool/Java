package org.xml.model;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class DataBaseUtil {
 private static Log logger = LogFactory.getLog(DataBaseUtil.class);
 
 public static final String DATASOURCE_FILENAME = "datasource.properties"; //�������ݿ������Դ�ļ�
 public static final String DATASOURCE_URL = "dataSource.url";             //����Դ�ļ���url��key
 public static final String DATASOURCE_USERNAME = "dataSource.username";   //����Դ�ļ����û�����key
 
 
 /**
  * ��ȡָ�����ݿ���û������б���
  * @param conn �������ݿ����
  * @param user �û�
  * @param database ���ݿ���
  * @return
  */
 public static List getAllTableNames(Connection conn) {
  List tableNames = new ArrayList();
  if (conn != null) {
   try {
    DatabaseMetaData dbmd = conn.getMetaData();
    // �����б�
    ResultSet rest = dbmd.getColumns(null, null, "nickname", "%");
    // ��� table_name
    while (rest.next()) {
	     System.out.println(rest.getString("COLUMN_NAME"));
     }
    }
   catch (SQLException e) {
	    e.printStackTrace();
	   }
   } 
   return tableNames;
  }
 
 
  public static void main(String [] args) {
		Connection connection=null;
		//�����ڴ�
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql:///myzh", "root", "123");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  List tables = getAllTableNames(connection);
  System.out.println(tables.size());
  
 }
}