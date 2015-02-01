package com.Factory.production;

import com.control.page.search_enterControlServlet;
import com.localhost.Factory.Shop_Factory;
import com.localhost.Interface.Shop_cr;

public class search_enterProduction implements Shop_Factory{

	public Shop_cr createShop_ab() {
		// TODO Auto-generated method stub
		return new search_enterControlServlet();
	}

}
