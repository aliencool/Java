package com.localhost.Factory;
import com.Model.DataImplc;
import com.Model.ShopDBBean;
import com.Model.Shop_adminDBBean;

public class DAOFACTORY {

	
	public static DataImplc getInstanceof()
	{
	return	new DataImplc();
	}
	
	public static ShopDBBean getInstanceofshop()
	{
	return	new ShopDBBean();
	}
	public static Shop_adminDBBean getInstanceofshop_admin()
	{
	return	new Shop_adminDBBean();
	}
	
}
