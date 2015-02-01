package org.sise.Dao;

public class DB_Factory {
	private DB_Factory(){}
	
	public static Dao_Imple getInstance()
	{
		return new Dao_Imple();
	}
}
