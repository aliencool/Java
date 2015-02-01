package com.Factory.production;

import com.control.page.car.addcarControlServlet;
import com.localhost.Factory.Shop_Factory;
import com.localhost.Interface.Shop_cr;

public class addcarProduction implements Shop_Factory{

	public Shop_cr createShop_ab() {
		// TODO Auto-generated method stub
		return new addcarControlServlet();
	}

}
