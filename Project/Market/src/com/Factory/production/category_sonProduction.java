package com.Factory.production;

import com.control.page.category.category_sonControlServlet;
import com.localhost.Factory.Shop_Factory;
import com.localhost.Interface.Shop_cr;

public class category_sonProduction implements Shop_Factory{

	public Shop_cr createShop_ab() {
		// TODO Auto-generated method stub
		return new category_sonControlServlet();
	}

}
