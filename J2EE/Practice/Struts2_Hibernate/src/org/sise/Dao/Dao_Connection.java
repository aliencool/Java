package org.sise.Dao;

import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Dao_Connection {
	public Session getSession()
	{
		//1:��xml���ؽ��ĵ�
		Configuration configuration=new Configuration();
		configuration.configure();
		//���session������
		SessionFactory factory=configuration.buildSessionFactory();
		//��ȡsession
		return factory.openSession();
	}
}
