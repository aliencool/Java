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
 
 public static final String DATASOURCE_FILENAME = "datasource.properties"; //连接数据库的数据源文件
 public static final String DATASOURCE_URL = "dataSource.url";             //数据源文件里url的key
 public static final String DATASOURCE_USERNAME = "dataSource.username";   //数据源文件里用户名的key
 
 
 /**
  * 获取指定数据库和用户的所有表名
  * @param conn 连接数据库对象
  * @param user 用户
  * @param database 数据库名
  * @return
  */
 public static List getAllTableNames(Connection conn) {
  List tableNames = new ArrayList();
  if (conn != null) {
   try {
    DatabaseMetaData dbmd = conn.getMetaData();
    // 表名列表
    ResultSet rest = dbmd.getColumns(null, null, "nickname", "%");
    // 输出 table_name
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
		//加载内存
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