package com.Factory.production;


import com.control.shopinfo.addshowmesControlServlet;
import com.localhost.Factory.Shop_Factory;
import com.localhost.Interface.Shop_cr;

public class addshowmesProduction implements Shop_Factory{

	public Shop_cr createShop_ab() {
		// TODO Auto-generated method stub
		return new addshowmesControlServlet();
	}

}
