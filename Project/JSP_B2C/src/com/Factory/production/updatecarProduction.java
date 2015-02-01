package com.Factory.production;

import com.control.page.car.updatecarControlServlet;
import com.localhost.Factory.Shop_Factory;
import com.localhost.Interface.Shop_cr;

public class updatecarProduction implements Shop_Factory{

	public Shop_cr createShop_ab() {
		// TODO Auto-generated method stub
		return new updatecarControlServlet();
	}

}
