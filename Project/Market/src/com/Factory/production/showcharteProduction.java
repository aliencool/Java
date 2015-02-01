package com.Factory.production;

import com.control.shopinfo.showcharteControlServlet;
import com.localhost.Factory.Shop_Factory;
import com.localhost.Interface.Shop_cr;

public class showcharteProduction  implements Shop_Factory{

	public Shop_cr createShop_ab() {
		// TODO Auto-generated method stub
		return new showcharteControlServlet();
	}

}
