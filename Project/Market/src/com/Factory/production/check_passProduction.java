package com.Factory.production;
import com.control.person.Check_passControlServlet;
import com.localhost.Factory.Shop_Factory;
import com.localhost.Interface.Shop_cr;
public class check_passProduction implements Shop_Factory{

	public Shop_cr createShop_ab() {
		// TODO Auto-generated method stub
		return new Check_passControlServlet();
	}

}
