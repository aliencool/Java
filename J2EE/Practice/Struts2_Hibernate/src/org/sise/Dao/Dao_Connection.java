package org.sise.Dao;

import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Dao_Connection {
	public Session getSession()
	{
		//1:把xml加载进文档
		Configuration configuration=new Configuration();
		configuration.configure();
		//获得session工厂类
		SessionFactory factory=configuration.buildSessionFactory();
		//获取session
		return factory.openSession();
	}
}
